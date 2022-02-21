package com.afrosin.lastpart.mvp.model

import com.afrosin.lastpart.utils.getDate
import java.util.*

data class Pulse(
    val dateCreated: Date,
    val topPressure: Int,
    val bottomPressure: Int,
    val pulse: Int
)

fun pulseList(): List<Pulse> {

    return listOf(
        Pulse(getDate(2022, Calendar.FEBRUARY, 24, 9, 0), 187, 87, 56),
        Pulse(getDate(2022, Calendar.FEBRUARY, 27, 9, 0), 166, 67, 62),
        Pulse(getDate(2022, Calendar.FEBRUARY, 20, 9, 0), 177, 77, 70)
    )
}