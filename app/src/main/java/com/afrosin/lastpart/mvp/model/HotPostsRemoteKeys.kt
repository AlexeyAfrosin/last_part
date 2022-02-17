package com.afrosin.lastpart.mvp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "hot_posts_remote_keys")
data class HotPostsRemoteKeys(
    @PrimaryKey val childrenDataId: Long,
    val prevKey: String?,
    val nextKey: String?
) : Parcelable