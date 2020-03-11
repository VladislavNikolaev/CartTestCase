package by.tsetserskaya.carttestcase.core

import kotlinx.coroutines.*
import moxy.MvpPresenter
import timber.log.Timber

abstract class BasePresenter<T : BaseView?> : MvpPresenter<T>() {

    private val loggingExceptionHandler = CoroutineExceptionHandler { _, t ->
        Timber.tag("CoroutineException").e("$t ${t.printStackTrace()}")
    }

    private var job = Job()

    val localScope = CoroutineScope(Dispatchers.Main + job) + loggingExceptionHandler


}