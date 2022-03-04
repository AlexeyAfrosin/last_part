package com.afrosin.lastpart.mvp.datasource

import com.afrosin.lastpart.mvp.model.Pulse
import com.github.terrakok.cicerone.Router

interface PulseDataSource {

    fun getPulseData(router: Router)
    fun setPulseData(pulse: Pulse)

}