package com.afrosin.lastpart.mvp.view.item

interface PulseItemView {
    var pos: Int

    fun setDateCreated(text: String)
    fun setTopPressure(text: String)
    fun setBottomPressure(text: String)
    fun setPulse(text: String)
}