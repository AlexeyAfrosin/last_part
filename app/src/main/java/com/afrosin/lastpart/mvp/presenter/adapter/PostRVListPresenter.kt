package com.afrosin.lastpart.mvp.presenter.adapter

import com.afrosin.lastpart.mvp.view.PostItemView

interface PostRVListPresenter {
    fun getCount(): Int
    fun bind(view: PostItemView)
}