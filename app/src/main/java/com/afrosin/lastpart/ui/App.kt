package com.afrosin.lastpart.ui

import android.app.Application
import com.afrosin.lastpart.di.AppComponent
import com.afrosin.lastpart.di.DaggerAppComponent
import com.afrosin.lastpart.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    }
}