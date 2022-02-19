package com.afrosin.lastpart.mvp.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.afrosin.lastpart.mvp.room.dao.HotPostDao
import com.afrosin.lastpart.mvp.room.dao.HotPostRemoteKeysDao

@Database(
    entities = [HotPostDao::class, HotPostRemoteKeysDao::class],
    version = 1,
    exportSchema = false
)
abstract class DatabaseLocal : RoomDatabase() {

    abstract fun hotPostDao(): HotPostDao
    abstract fun hotPostRemoteKeysDao(): HotPostRemoteKeysDao

    companion object {
        const val DB_NAME = "database.db"
    }
}