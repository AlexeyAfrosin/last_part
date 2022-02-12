package com.afrosin.lastpart.mvp.model

import com.afrosin.lastpart.utils.getDate
import java.util.*

data class Exam(
    val name: String,
    val startDate: Date
) {

}

private fun examList(): List<Exam> {

    return listOf(
        Exam("Английский", getDate(2022, Calendar.FEBRUARY, 24, 9, 0)),
        Exam("Мат.анализ", getDate(2022, Calendar.FEBRUARY, 27, 9, 0)),
        Exam("Химия", getDate(2022, Calendar.FEBRUARY, 20, 9, 0))
    )
}

fun examListSorted(): List<Exam> {
    return examList().sortedBy { elem -> elem.startDate }
}
