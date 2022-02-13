package com.afrosin.lastpart.mvp.presenter.adapter

import com.afrosin.lastpart.mvp.view.item.HomeworkItemView

interface HomeworkRVListPresenter {
    fun getCount(): Int
    fun bind(view: HomeworkItemView)
}