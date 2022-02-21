package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.model.Pulse
import com.afrosin.lastpart.mvp.model.pulseList
import com.afrosin.lastpart.mvp.presenter.adapter.PulseRVListPresenter
import com.afrosin.lastpart.mvp.view.PulseFragmentView
import com.afrosin.lastpart.mvp.view.item.PulseItemView
import com.afrosin.lastpart.navigation.Screens
import com.afrosin.lastpart.utils.toStringFormat
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class PulseFragmentPresenter : MvpPresenter<PulseFragmentView>() {


    companion object {
        const val ADD_PULSE_DATA_RESULT = "ADD_PULSE_DATA_RESULT"
    }

    @Inject
    lateinit var router: Router

    private var addPulseDataResultListener: ResultListenerHandler? = null

    val listPresenter = FrPulseRVListPresenter()

    inner class FrPulseRVListPresenter : PulseRVListPresenter {
        val pulseList = mutableListOf<Pulse>()

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
        listPresenter.pulseList.addAll(pulseList())
        viewState.init()
    }

    fun showAddPulseDataDialog() {
        addPulseDataResultListener =
            router.setResultListener(ADD_PULSE_DATA_RESULT) { newPulseData ->
                (newPulseData as? Pulse)?.let { pulse ->
                    listPresenter.pulseList.add(pulse)

                    viewState.updateRecyclerView(listPresenter.getCount() - 1)
                }
            }
        router.navigateTo(Screens.addPulseDataDialogFragment())
    }

    override fun onDestroy() {
        super.onDestroy()
        addPulseDataResultListener?.dispose()
    }

}