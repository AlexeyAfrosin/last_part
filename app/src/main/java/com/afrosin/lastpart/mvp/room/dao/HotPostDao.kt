package com.afrosin.lastpart.mvp.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afrosin.lastpart.mvp.model.HotPost

@Dao
interface HotPostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(hotPosts: List<HotPost>)

    @Query("SELECT * FROM hot_posts")
    fun selectAll(): PagingSource<Int, HotPost>

}

