package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.model.Pulse
import com.afrosin.lastpart.mvp.presenter.PulseFragmentPresenter.Companion.ADD_PULSE_DATA_RESULT
import com.afrosin.lastpart.mvp.view.AddPulseDataFragmentView
import com.afrosin.lastpart.utils.currentTime
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class AddPulseDataDialogFragmentPresenter : MvpPresenter<AddPulseDataFragmentView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun btCancelClick() {
        router.exit()
    }

    fun saveData(topPressure: String, bottomPressure: String, pulse: String) {
        router.sendResult(
            ADD_PULSE_DATA_RESULT, Pulse(
                currentTime(), topPressure.toInt(),
                bottomPressure.toInt(),
                pulse.toInt()
            )
        )
        router.exit()
    }


}