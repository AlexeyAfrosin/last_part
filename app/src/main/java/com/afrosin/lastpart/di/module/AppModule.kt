package com.afrosin.lastpart.di.module

import com.afrosin.lastpart.ui.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App {
        return app
    }
}