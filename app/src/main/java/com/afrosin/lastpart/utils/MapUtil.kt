package com.afrosin.lastpart.utils

import com.afrosin.lastpart.mvp.model.HotPost
import com.afrosin.lastpart.mvp.model.HotPostListing
import com.afrosin.lastpart.mvp.model.PostContainer
import com.afrosin.lastpart.mvp.model.response.HotPostApiResponse
import com.afrosin.lastpart.mvp.model.response.HotPostResponse
import com.afrosin.lastpart.mvp.model.response.PostContainerResponse


fun mapToHotPostListing(responsePost: HotPostApiResponse): HotPostListing {
    return HotPostListing(
        responsePost.hotPostListing.after,
        responsePost.hotPostListing.before,
        mapToPostContainer(responsePost.hotPostListing.postContainerResponse)
    )
}

fun mapToPostContainer(postContainerResponse: List<PostContainerResponse>): List<PostContainer> {
    return postContainerResponse.map { item ->
        PostContainer(
            mapToHotPost(item.data)
        )
    }
}

fun mapToHotPost(hotPostResponse: HotPostResponse): HotPost {
    return HotPost(hotPostResponse.key, hotPostResponse.title)
}
