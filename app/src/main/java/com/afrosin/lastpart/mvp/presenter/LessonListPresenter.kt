package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.model.Lesson
import com.afrosin.lastpart.mvp.model.lessonListSorted
import com.afrosin.lastpart.mvp.presenter.adapter.LessonRVListPresenter
import com.afrosin.lastpart.mvp.view.BaseFragmentView
import com.afrosin.lastpart.mvp.view.ClassesFragmentView
import com.afrosin.lastpart.mvp.view.item.LessonItemView
import com.afrosin.lastpart.utils.currentTime
import com.afrosin.lastpart.utils.toStringFormat

class LessonListPresenter(viewStateBase: BaseFragmentView) : LessonRVListPresenter {
    private val lessonList = lessonListSorted()
    private val viewState = viewStateBase
    private val isClassesView = (viewState is ClassesFragmentView)

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
            if (isClassesView && lesson.isAdditional) {
                setLessonAdditionalLessonCardBackgroundColor()
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