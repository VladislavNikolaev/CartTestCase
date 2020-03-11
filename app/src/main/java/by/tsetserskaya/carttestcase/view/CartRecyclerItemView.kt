package by.tsetserskaya.carttestcase.view

import by.tsetserskaya.carttestcase.core.BaseView
import by.tsetserskaya.carttestcase.model.response.CartItemResponse
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface CartRecyclerItemView : BaseView {

    fun cartReceived(items: List<CartItemResponse>?)

    fun navigateToDetails(productId: Int)
}