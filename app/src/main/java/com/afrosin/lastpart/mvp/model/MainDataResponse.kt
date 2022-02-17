package com.afrosin.lastpart.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MainDataResponse(
    @Expose
    @SerializedName("after")
    val after: String,
    @Expose
    @SerializedName("dist")
    val dist: Int,
    @Expose
    @SerializedName("children")
    val children: List<ChildrenResponse>
)