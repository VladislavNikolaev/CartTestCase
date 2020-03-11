package by.tsetserskaya.carttestcase.presenter

import by.tsetserskaya.carttestcase.core.BasePresenter
import by.tsetserskaya.carttestcase.model.CartRepository
import by.tsetserskaya.carttestcase.ui.ClickViewEvent
import by.tsetserskaya.carttestcase.ui.ProductClickEvent
import by.tsetserskaya.carttestcase.view.CartRecyclerItemView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CartRecyclerItemPresenter @Inject constructor(
    private val cartRepository: CartRepository
//    private val cartMapper: CartMapper
) : BasePresenter<CartRecyclerItemView>() {


    fun fetchData() {
        localScope.launch {
            viewState.cartReceived(cartRepository.getCart())
        }
    }

    fun onEventClickListener(event: ClickViewEvent) {
        when (event) {
            is ProductClickEvent -> {
                viewState.navigateToDetails(event.productId)
            }
        }

    }

}