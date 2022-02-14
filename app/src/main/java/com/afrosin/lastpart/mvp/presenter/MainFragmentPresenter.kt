package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.view.MainFragmentView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainFragmentPresenter : MvpPresenter<MainFragmentView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

}