package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        router.newRootScreen(Screens.rootFragment())
    }

}