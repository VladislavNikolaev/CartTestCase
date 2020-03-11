package by.tsetserskaya.carttestcase.model

import by.tsetserskaya.carttestcase.model.response.CartDetailItemResponse
import by.tsetserskaya.carttestcase.model.response.CartItemResponse
import by.tsetserskaya.carttestcase.network.CartApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepository @Inject constructor(
    private val cartApi: CartApi
) {

    suspend fun getCartProductDetails(id: Int): CartDetailItemResponse? {

        val response = cartApi.getDetails(id)
        return if (response.isSuccessful) {
            response.body()
        } else null

    }

    suspend fun getCart(): List<CartItemResponse>? {

        val response = cartApi.getCart()
        return if (response.isSuccessful) {
            response.body()?.products
        } else emptyList()

    }


}