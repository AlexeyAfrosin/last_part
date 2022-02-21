package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.view.PulseFragmentView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class PulseFragmentPresenter : MvpPresenter<PulseFragmentView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

}