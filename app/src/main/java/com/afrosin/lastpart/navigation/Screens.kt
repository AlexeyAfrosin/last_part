package com.afrosin.lastpart.navigation

import com.afrosin.lastpart.ui.fragment.PulseFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun pulseFragment() =
        FragmentScreen { PulseFragment.newInstance() }
}