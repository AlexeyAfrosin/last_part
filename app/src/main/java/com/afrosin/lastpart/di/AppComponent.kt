package com.afrosin.lastpart.di

import com.afrosin.lastpart.di.module.AppModule
import com.afrosin.lastpart.di.module.CiceroneModule
import com.afrosin.lastpart.di.module.RepoModule
import com.afrosin.lastpart.mvp.presenter.MainFragmentPresenter
import com.afrosin.lastpart.mvp.presenter.MainPresenter
import com.afrosin.lastpart.ui.App
import com.afrosin.lastpart.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RepoModule::class,
        CiceroneModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

    fun inject(mainFragmentPresenter: MainFragmentPresenter)
}