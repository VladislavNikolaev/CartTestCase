package by.tsetserskaya.carttestcase.presenter

import by.tsetserskaya.carttestcase.core.BasePresenter
import by.tsetserskaya.carttestcase.model.CartRepository
import by.tsetserskaya.carttestcase.view.ProductDetailView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ProductDetailPresenter @Inject constructor(
    private val cartRepository: CartRepository
//    private val cartMapper: CartMapper
) : BasePresenter<ProductDetailView>() {


    fun getProduct(productId: Int) {
        localScope.launch {
            viewState.productReceived(cartRepository.getCartProductDetails(productId))
        }
    }

}