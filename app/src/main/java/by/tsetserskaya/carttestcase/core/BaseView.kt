package by.tsetserskaya.carttestcase.core

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface BaseView : MvpView {

//    fun showProgressBar()
//    fun hideProgressBar()

}