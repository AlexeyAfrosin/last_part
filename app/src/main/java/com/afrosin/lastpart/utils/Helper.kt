package com.afrosin.lastpart.utils

import java.text.SimpleDateFormat
import java.util.*

fun getDate(year: Int, month: Int, date: Int, hrs: Int, min: Int): Date {
    val cal = Calendar.getInstance()
    cal[Calendar.YEAR] = year
    cal[Calendar.MONTH] = month
    cal[Calendar.DAY_OF_MONTH] = date
    cal[Calendar.HOUR_OF_DAY] = hrs
    cal[Calendar.MINUTE] = min
    return cal.time
}

fun Date.toStringFormat(patternDate: String = "dd.MM.yyyy HH:mm:ss"): String =
    SimpleDateFormat(patternDate, Locale.getDefault()).format(this)