package com.afrosin.lastpart.mvp.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HotPostListingResponse(
    @Expose
    @SerializedName("after")
    val after: String?,
    @Expose
    @SerializedName("before")
    val before: String?,
    @Expose
    @SerializedName("children")
    val postContainerResponse: List<PostContainerResponse>
)