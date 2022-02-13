package com.afrosin.lastpart.mvp.view.item

interface HomeworkItemView {
    var pos: Int

    fun setHomeworkName(text: String)
    fun setHomeworkDeadlineDate(text: String)
    fun setHomeworkDescription(text: String)
}