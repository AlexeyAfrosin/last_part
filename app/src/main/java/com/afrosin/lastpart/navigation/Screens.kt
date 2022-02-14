package com.afrosin.lastpart.navigation

import com.afrosin.lastpart.ui.fragment.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun mainFragment() =
        FragmentScreen { MainFragment.newInstance() }
}