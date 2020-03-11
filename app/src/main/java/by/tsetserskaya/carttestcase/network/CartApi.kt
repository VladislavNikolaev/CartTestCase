package by.tsetserskaya.carttestcase.network

import by.tsetserskaya.carttestcase.model.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CartApi {

    @GET("cart/{product_id}/detail")
    suspend fun getDetails(@Path("product_id") id: Int): Response<CartDetailItemResponse>

    @GET("cart/list")
    suspend fun getCart(): Response<CartResponse>

}