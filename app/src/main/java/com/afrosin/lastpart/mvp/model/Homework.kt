package com.afrosin.lastpart.mvp.model

import com.afrosin.lastpart.utils.getDate
import java.util.*

data class Homework(
    val name: String,
    val description: String,
    val deadLineDate: Date
)

private fun homeworkList(): List<Homework> {

    return listOf(
        Homework(
            "Английский",
            "Перевод текста, страница 3",
            getDate(2022, Calendar.FEBRUARY, 24, 9, 0)
        ),
        Homework(
            "Мат.анализ",
            "Задания 3 и 4, страница 28",
            getDate(2022, Calendar.FEBRUARY, 27, 9, 0)
        ),
        Homework(
            "Химия",
            "Параграф 39, 40. Задания 1, 2",
            getDate(2022, Calendar.FEBRUARY, 20, 9, 0)
        )
    )
}

fun homeworkListSorted(): List<Homework> {
    return homeworkList().sortedBy { elem -> elem.deadLineDate }
}
