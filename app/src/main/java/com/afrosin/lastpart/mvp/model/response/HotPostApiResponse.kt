package com.afrosin.lastpart.mvp.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HotPostApiResponse(
    @Expose
    @SerializedName("data")
    val hotPostListing: HotPostListingResponse
)