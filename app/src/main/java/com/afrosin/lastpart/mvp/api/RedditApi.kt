package com.afrosin.lastpart.mvp.api

import com.afrosin.lastpart.mvp.model.HotPostsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {
    @GET("r/aww/hot.json")
    fun getHotPosts(
        @Query("count") count: Int = 1,
        @Query("after") after: String = ""
    ): Single<HotPostsResponse>
}