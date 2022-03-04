package com.afrosin.lastpart.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PulseFragmentView : MvpView {
    fun init()
    fun notifyInsertItem(pos: Int)
    fun notifyDataSetChanged()
}