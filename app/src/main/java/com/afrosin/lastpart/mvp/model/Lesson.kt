package com.afrosin.lastpart.mvp.model

import com.afrosin.lastpart.utils.getDate
import java.util.*

data class Lesson(
    val name: String,
    val startDate: Date,
    val openInSkype: Boolean = false
)

private fun lessonList(): List<Lesson> {

    return listOf(
        Lesson("Английский", getDate(2022, Calendar.FEBRUARY, 24, 9, 0), true),
        Lesson("Мат.анализ", getDate(2022, Calendar.FEBRUARY, 27, 9, 0)),
        Lesson("Химия", getDate(2022, Calendar.FEBRUARY, 20, 9, 0), true),
        Lesson("Биология", getDate(2022, Calendar.FEBRUARY, 12, 21, 45), true),
        Lesson("Физкультура", getDate(2022, Calendar.FEBRUARY, 12, 20, 13), true),
        Lesson("Русский язык", getDate(2022, Calendar.FEBRUARY, 12, 16, 13), true)
    )
}

fun lessonListSorted(): List<Lesson> {
    return lessonList().sortedBy { elem -> elem.startDate }
}
