package com.afrosin.lastpart.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HotPostsResponse(
    @Expose
    @SerializedName("kind")
    val kind: String,
    @Expose
    @SerializedName("data")
    val data: MainDataResponse
)