package com.afrosin.lastpart.mvp.model

data class HotPostListing(
    val after: String?,
    val before: String?,
    val postContainer: List<PostContainer>
)