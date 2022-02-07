package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.view.HomeFragmentView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class HomeFragmentPresenter : MvpPresenter<HomeFragmentView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

}