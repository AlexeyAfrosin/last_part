package com.afrosin.lastpart.mvp.room.rx

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afrosin.lastpart.mvp.model.HotPostsRemoteKeys

@Dao
interface HotPostRemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(remoteKey: List<HotPostsRemoteKeys>)

    @Query("SELECT * FROM hot_posts_remote_keys WHERE childrenDataId = :childrenDataId")
    fun remoteKeysByMovieId(childrenDataId: Long): HotPostsRemoteKeys?

    @Query("DELETE FROM hot_posts_remote_keys")
    fun clearRemoteKeys()

}