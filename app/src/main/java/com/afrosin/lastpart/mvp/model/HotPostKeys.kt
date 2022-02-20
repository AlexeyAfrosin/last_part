package com.afrosin.lastpart.mvp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hot_post_keys")
data class HotPostKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val after: String?,
    val before: String?
)
