package com.afrosin.lastpart.di.module

import androidx.room.Room
import com.afrosin.lastpart.mvp.api.RedditApi
import com.afrosin.lastpart.mvp.network.NetworkStatus
import com.afrosin.lastpart.mvp.repo.ApiRepo
import com.afrosin.lastpart.mvp.repo.RoomRepo
import com.afrosin.lastpart.mvp.resource.ResourceProvider
import com.afrosin.lastpart.mvp.room.db.DatabaseLocal
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
    fun apiRepo(api: RedditApi, networkStatus: NetworkStatus): ApiRepo {
        return ApiRepo(api, networkStatus)
    }

    @Singleton
    @Provides
    fun database(app: App): DatabaseLocal {
        return Room.databaseBuilder(app, DatabaseLocal::class.java, DatabaseLocal.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun roomRepo(database: DatabaseLocal): RoomRepo {
        return RoomRepo(database)
    }

}