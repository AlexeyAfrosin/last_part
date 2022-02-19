package com.afrosin.lastpart.mvp.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afrosin.lastpart.mvp.model.ChildrenData

@Dao
interface HotPostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(childrenData: List<ChildrenData>)

    @Query("SELECT * FROM children_datas ORDER BY id ASC")
    fun selectAll(): PagingSource<Int, ChildrenData>

}

