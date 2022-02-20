package com.afrosin.lastpart.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.afrosin.lastpart.models.RedditKeys

@Dao
interface RedditKeysDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveRedditKeys(redditKey: RedditKeys)

    @Query("SELECT * FROM redditKeys ORDER BY id DESC")
    suspend fun getRedditKeys(): List<RedditKeys>

}