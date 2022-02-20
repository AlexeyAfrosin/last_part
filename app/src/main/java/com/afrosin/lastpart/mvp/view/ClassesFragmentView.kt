package com.afrosin.lastpart.mvp.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ClassesFragmentView : BaseFragmentView {

}