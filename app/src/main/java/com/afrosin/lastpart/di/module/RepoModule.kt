package com.afrosin.lastpart.di.module

import com.afrosin.lastpart.mvp.datasource.PulseDataSource
import com.afrosin.lastpart.mvp.datasource.PulseDataSourceFirebaseImpl
import com.afrosin.lastpart.mvp.resource.ResourceProvider
import com.afrosin.lastpart.ui.App
import com.afrosin.lastpart.ui.resource.AndroidResourceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun resourceProvider(app: App): ResourceProvider {
        return AndroidResourceProvider(app)
    }

    @Singleton
    @Provides
    fun firebaseDataSource(): PulseDataSource {
        return PulseDataSourceFirebaseImpl()
    }
}