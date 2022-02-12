package com.afrosin.lastpart.mvp.presenter

import android.os.CountDownTimer
import com.afrosin.lastpart.mvp.model.examListSorted
import com.afrosin.lastpart.mvp.view.HomeFragmentView
import com.afrosin.lastpart.utils.dateDiff
import com.afrosin.lastpart.utils.toStringFormat
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.*

@InjectViewState
class HomeFragmentPresenter : MvpPresenter<HomeFragmentView>() {

    private val examList = examListSorted()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        initCountDownTimer(
            dateDiff(Calendar.getInstance().time, examList[0].startDate)
        )
    }

    private fun initCountDownTimer(millisUntilFinished: Long) {
        object : CountDownTimer(millisUntilFinished, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val dateStr = Date(millisUntilFinished).toStringFormat("ddHHmmss")
                viewState.setDay1ToExam(dateStr[0].toString())
                viewState.setDay2ToExam(dateStr[1].toString())
                viewState.setHour1ToExam(dateStr[2].toString())
                viewState.setHour2ToExam(dateStr[3].toString())
                viewState.setMinute1ToExam(dateStr[4].toString())
                viewState.setMinute2ToExam(dateStr[5].toString())
                viewState.setSecond1ToExam(dateStr[6].toString())
                viewState.setSecond2ToExam(dateStr[7].toString())
            }

            override fun onFinish() {
            }
        }.start()

    }

}