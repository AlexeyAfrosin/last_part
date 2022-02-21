package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.model.Pulse
import com.afrosin.lastpart.mvp.model.pulseList
import com.afrosin.lastpart.mvp.presenter.adapter.PulseRVListPresenter
import com.afrosin.lastpart.mvp.view.PulseFragmentView
import com.afrosin.lastpart.mvp.view.item.PulseItemView
import com.afrosin.lastpart.utils.toStringFormat
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class PulseFragmentPresenter : MvpPresenter<PulseFragmentView>() {

    val listPresenter = FrPulseRVListPresenter()

    inner class FrPulseRVListPresenter : PulseRVListPresenter {
        private val pulseList = pulseList()


        override fun getCount(): Int = pulseList.size

        override fun bind(view: PulseItemView) {
            initView(view, getPulse(view.pos))
        }

        private fun getPulse(pos: Int): Pulse = pulseList[pos]


        private fun initView(view: PulseItemView, pulse: Pulse) {
            with(view) {
                setDateCreated(pulse.dateCreated.toStringFormat("dd.MM.yyyy HH:mm"))
                setTopPressure(pulse.topPressure.toString())
                setBottomPressure(pulse.bottomPressure.toString())
                setPulse(pulse.pulse.toString())

            }
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

}