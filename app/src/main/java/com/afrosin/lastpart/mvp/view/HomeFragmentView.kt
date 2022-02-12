package com.afrosin.lastpart.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface HomeFragmentView : MvpView {
    fun init()
    fun setDay1ToExam(text: String)
    fun setDay2ToExam(text: String)
    fun setHour1ToExam(text: String)
    fun setHour2ToExam(text: String)
    fun setMinute1ToExam(text: String)
    fun setMinute2ToExam(text: String)
    fun setSecond1ToExam(text: String)
    fun setSecond2ToExam(text: String)
}