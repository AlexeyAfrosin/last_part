package com.afrosin.lastpart.mvp.presenter

import android.os.CountDownTimer
import com.afrosin.lastpart.mvp.model.Lesson
import com.afrosin.lastpart.mvp.model.examListSorted
import com.afrosin.lastpart.mvp.model.lessonListSorted
import com.afrosin.lastpart.mvp.presenter.adapter.LessonRVListPresenter
import com.afrosin.lastpart.mvp.view.HomeFragmentView
import com.afrosin.lastpart.mvp.view.item.LessonItemView
import com.afrosin.lastpart.utils.currentTime
import com.afrosin.lastpart.utils.dateDiff
import com.afrosin.lastpart.utils.toStringFormat
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.*


@InjectViewState
class HomeFragmentPresenter : MvpPresenter<HomeFragmentView>() {

    private val examList = examListSorted()

    val listPresenter = HomeLessonRVListPresenter()

    inner class HomeLessonRVListPresenter : LessonRVListPresenter {
        private val lessonList = lessonListSorted()

        //длительность урока в милисекундах
        private val lessonDuration = 40 * 60 * 1000

        override fun getCount(): Int = lessonList.size

        override fun bind(view: LessonItemView) {
            initView(view, getLesson(view.pos))
        }

        private fun getLesson(pos: Int): Lesson = lessonList[pos]


        private fun initView(view: LessonItemView, lesson: Lesson) {
            with(view) {
                setLessonName(lesson.name)
                setLessonDate(lesson.startDate.toStringFormat("dd.MM.yyyy HH:mm"))

                if (lesson.openInSkype) {
                    setLessonOpenInShow()
                } else {
                    setLessonOpenInHide()
                }

            }
        }

        override fun openSkype(view: LessonItemView) {
            val appName = "Skype"
            val packageName = "com.skype.raider"
            viewState.openApp(appName, packageName)
        }

        override fun actualPosition(): Int {
            val currDate = currentTime()

            lessonList.forEachIndexed { pos, lesson ->

                if ((currDate.time - lesson.startDate.time <= lessonDuration) || (currDate.time + lessonDuration <= lesson.startDate.time)) {
                    return pos
                }
            }
            return getCount() - 1
        }
    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        initCountDownTimer(
            dateDiff(Calendar.getInstance().time, examList[0].startDate)
        )

        viewState.scrollRvLesson(listPresenter.actualPosition())

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