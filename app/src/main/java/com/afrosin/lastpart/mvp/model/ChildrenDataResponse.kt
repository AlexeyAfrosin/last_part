package com.afrosin.lastpart.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChildrenDataResponse(
    @Expose
    @SerializedName("title")
    val title: String
)