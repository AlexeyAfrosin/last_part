package com.afrosin.lastpart.mvp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hot_posts")
data class HotPost(
    @PrimaryKey
    val key: String,
    val title: String
)
