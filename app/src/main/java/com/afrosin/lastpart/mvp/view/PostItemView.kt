package com.afrosin.lastpart.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PostItemView : MvpView {
    var pos: Int
    fun setPostText(text: String)
}