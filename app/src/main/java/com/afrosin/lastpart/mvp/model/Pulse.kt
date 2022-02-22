package com.afrosin.lastpart.mvp.model

import java.util.*

data class Pulse(
    val dateCreated: Date,
    val topPressure: Int,
    val bottomPressure: Int,
    val pulse: Int
)