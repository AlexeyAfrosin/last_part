package com.afrosin.lastpart.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.afrosin.lastpart.database.dao.RedditKeysDao
import com.afrosin.lastpart.database.dao.RedditPostsDao
import com.afrosin.lastpart.models.RedditKeys
import com.afrosin.lastpart.models.RedditPost

@Database(
    entities = [RedditPost::class, RedditKeys::class],
    version = 1,
    exportSchema = false
)
abstract class RedditDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context): RedditDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, RedditDatabase::class.java, "redditclone.db")
            return databaseBuilder.build()
        }
    }

    abstract fun redditPostsDao(): RedditPostsDao
    abstract fun redditKeysDao(): RedditKeysDao
}