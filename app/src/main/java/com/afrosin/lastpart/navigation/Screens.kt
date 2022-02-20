package com.afrosin.lastpart.navigation

import com.afrosin.lastpart.ui.fragment.ClassesFragment
import com.afrosin.lastpart.ui.fragment.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun homeFragment() =
        FragmentScreen { HomeFragment.newInstance() }

    fun classesFragment() =
        FragmentScreen { ClassesFragment.newInstance() }
}