package by.tsetserskaya.carttestcase.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import by.tsetserskaya.carttestcase.R
import by.tsetserskaya.carttestcase.core.BaseFragment
import by.tsetserskaya.carttestcase.core.BasePresenter
import by.tsetserskaya.carttestcase.model.response.CartDetailItemResponse
import by.tsetserskaya.carttestcase.presenter.ProductDetailPresenter
import by.tsetserskaya.carttestcase.view.ProductDetailView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_product_detail.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class ProductDetailFragment : BaseFragment(), ProductDetailView {

    override val layout: Int
        get() = R.layout.fragment_product_detail
    override val basePresenter: BasePresenter<*>?
        get() = presenter
    override val baseContent: ViewGroup?
        get() = null

    private val args by navArgs<ProductDetailFragmentArgs>()

    @Inject
    lateinit var daggerPresenter: Lazy<ProductDetailPresenter>

    @InjectPresenter
    lateinit var presenter: ProductDetailPresenter

    @ProvidePresenter
    fun providePresenter(): ProductDetailPresenter = daggerPresenter.get()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getProduct(args.productId)
    }

    override fun productReceived(product: CartDetailItemResponse?) {

        product?.let {

            title.text = product.name
            description.text = product.description
            price_tag.text = product.price.toString()

            if (!product.image.isNullOrBlank()) {
                Glide.with(requireContext())
                    .load(product.image)
                    .apply(
                        RequestOptions()
                            .fitCenter()
                            .override(
                                300, 300
                            )
                    )
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .skipMemoryCache(true)
                    .into(img_view)
            }
        }


    }
}