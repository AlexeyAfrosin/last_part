package com.afrosin.lastpart.mvp.presenter

import android.os.CountDownTimer
import com.afrosin.lastpart.mvp.model.Homework
import com.afrosin.lastpart.mvp.model.examListSorted
import com.afrosin.lastpart.mvp.model.homeworkListSorted
import com.afrosin.lastpart.mvp.presenter.adapter.HomeworkRVListPresenter
import com.afrosin.lastpart.mvp.view.HomeFragmentView
import com.afrosin.lastpart.mvp.view.item.HomeworkItemView
import com.afrosin.lastpart.utils.dateDiff
import com.afrosin.lastpart.utils.toStringFormat
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.*


@InjectViewState
class HomeFragmentPresenter : MvpPresenter<HomeFragmentView>() {

    private val examList = examListSorted()

    val lessonPresenter = LessonListPresenter(viewState)
    val homeworkPresenter = HHomeworkRVListPresenter()

    inner class HHomeworkRVListPresenter : HomeworkRVListPresenter {
        private val homeworkList = homeworkListSorted()

        override fun getCount(): Int = homeworkList.size
        private fun getHomework(pos: Int): Homework = homeworkList[pos]

        override fun bind(view: HomeworkItemView) {
            initView(view, getHomework(view.pos))
        }

        private fun initView(view: HomeworkItemView, homework: Homework) {
            with(view) {
                setHomeworkName(homework.name)
                setHomeworkDeadlineDate(homework.deadLineDate.toStringFormat("dd.MM.yyyy HH:mm"))
                setHomeworkDescription(homework.description)
            }
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        initCountDownTimer(
            dateDiff(Calendar.getInstance().time, examList[0].startDate)
        )

        viewState.scrollRvLesson(lessonPresenter.actualPosition())

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