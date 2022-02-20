package com.afrosin.lastpart.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "redditPosts")
data class RedditPost(
    @SerializedName("name")
    @PrimaryKey
    val key: String,
    @SerializedName("title")
    val title: String
)
