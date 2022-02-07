package com.afrosin.lastpart.ui

import android.os.Bundle
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.ActivityMainBinding
import com.afrosin.lastpart.mvp.presenter.MainPresenter
import com.afrosin.lastpart.mvp.view.MainView
import com.afrosin.lastpart.navigation.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding


    @InjectPresenter
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    @ProvidePresenter
    fun providePresenter() = MainPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private val navigator = object : AppNavigator(this, R.id.container) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun init() {
        initListeners()
    }

    private fun initListeners() {
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mi_home -> router.navigateTo(Screens.homeFragment())
                R.id.mi_classes -> router.navigateTo(Screens.classesFragment())
            }
            true
        }
    }

    override fun exit() {
        finish()
    }
}