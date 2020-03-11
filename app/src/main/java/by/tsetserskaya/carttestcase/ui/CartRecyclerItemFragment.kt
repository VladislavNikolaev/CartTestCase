package by.tsetserskaya.carttestcase.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.*
import by.tsetserskaya.carttestcase.R
import by.tsetserskaya.carttestcase.core.BaseFragment
import by.tsetserskaya.carttestcase.core.BasePresenter
import by.tsetserskaya.carttestcase.model.response.CartItemResponse
import by.tsetserskaya.carttestcase.presenter.CartRecyclerItemPresenter
import by.tsetserskaya.carttestcase.utils.navigateSafe
import by.tsetserskaya.carttestcase.view.CartRecyclerItemView
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_cart_recycler_item_list.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

typealias ClickViewListener = (ClickViewEvent) -> Unit

sealed class ClickViewEvent
data class ProductClickEvent(val productId: Int) : ClickViewEvent()

class CartRecyclerItemFragment : BaseFragment(), CartRecyclerItemView {

    override val layout: Int
        get() = R.layout.fragment_cart_recycler_item_list
    override val basePresenter: BasePresenter<*>?
        get() = presenter
    override val baseContent: ViewGroup?
        get() = null

    private var columnCount = 2

    private lateinit var cartAdapter: MyCartRecyclerItemRecyclerViewAdapter


    @Inject
    lateinit var daggerPresenter: Lazy<CartRecyclerItemPresenter>

    @InjectPresenter
    lateinit var presenter: CartRecyclerItemPresenter

    @ProvidePresenter
    fun providePresenter(): CartRecyclerItemPresenter = daggerPresenter.get()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
            }
        }

        presenter.fetchData()
    }

    override fun cartReceived(items: List<CartItemResponse>?) {
        if (!items.isNullOrEmpty()) {
            cartAdapter = MyCartRecyclerItemRecyclerViewAdapter(items)
            cartAdapter.listener = presenter::onEventClickListener
            recyclerView.adapter = cartAdapter
        }
    }

    override fun navigateToDetails(productId: Int) {
        navController.navigateSafe(
            R.id.action_cartFragment_to_productDetailFragment,
            bundleOf("productId" to productId)
        )
    }
}
