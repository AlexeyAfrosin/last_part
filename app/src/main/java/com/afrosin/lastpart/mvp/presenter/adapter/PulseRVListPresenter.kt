package com.afrosin.lastpart.mvp.presenter.adapter

import com.afrosin.lastpart.mvp.view.item.PulseItemView

interface PulseRVListPresenter {
    fun getCount(): Int
    fun bind(view: PulseItemView)
}