package com.afrosin.lastpart.mvp.view.item

interface LessonItemView {
    var pos: Int

    fun setLessonName(text: String)
    fun setLessonDate(text: String)
    fun setLessonOpenInShow()
    fun setLessonOpenInHide()
}