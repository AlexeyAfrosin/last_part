package com.afrosin.lastpart.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BaseFragmentView : MvpView {
    fun init()
    fun openApp(appName: String, packageName: String?)
    fun scrollRvLesson(position: Int)
}