package com.afrosin.lastpart.mvp.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afrosin.lastpart.mvp.model.HotPostKeys

@Dao
interface HotPostRemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKey(hotPostKeys: HotPostKeys)

    @Query("SELECT * FROM hot_post_keys ORDER BY id DESC")
    fun getKeys(): List<HotPostKeys>

}