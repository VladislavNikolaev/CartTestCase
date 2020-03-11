package by.tsetserskaya.carttestcase.view

import by.tsetserskaya.carttestcase.core.BaseView
import by.tsetserskaya.carttestcase.model.response.CartDetailItemResponse
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface ProductDetailView : BaseView {

    fun productReceived(product: CartDetailItemResponse?)

}