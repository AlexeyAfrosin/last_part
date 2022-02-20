package com.afrosin.lastpart.mvp.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HotPostResponse(
    @Expose
    @SerializedName("name")
    val key: String,
    @Expose
    @SerializedName("title")
    val title: String
)