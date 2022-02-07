package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.view.ClassesFragmentView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class ClassesFragmentPresenter : MvpPresenter<ClassesFragmentView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

}