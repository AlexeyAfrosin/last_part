package com.afrosin.lastpart.mvp.presenter.adapter

import com.afrosin.lastpart.mvp.view.item.LessonItemView

interface LessonRVListPresenter {
    fun getCount(): Int
    fun bind(view: LessonItemView)
    fun openSkype(view: LessonItemView)
    fun actualPosition(): Int
}