package by.tsetserskaya.carttestcase.model.response


import com.google.gson.annotations.SerializedName

data class CartResponse(
    @SerializedName("products")
    val products: List<CartItemResponse>
)