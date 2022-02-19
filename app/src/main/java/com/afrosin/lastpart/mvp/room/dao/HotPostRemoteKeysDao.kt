package com.afrosin.lastpart.mvp.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afrosin.lastpart.mvp.model.HotPostsRemoteKeys

@Dao
interface HotPostRemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(remoteKey: List<HotPostsRemoteKeys>)

    @Query("SELECT * FROM hot_posts_remote_keys ORDER BY id DESC")
    fun getKeys(): List<HotPostsRemoteKeys>

}