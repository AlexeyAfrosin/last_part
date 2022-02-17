package com.afrosin.lastpart.utils

import com.afrosin.lastpart.mvp.model.*


fun mapToHotPost(responsePost: HotPostsResponse): HotPosts {
    return HotPosts(
        responsePost.kind,
        mapToMainData(responsePost.data)
    )
}

fun mapToMainData(mainDataResponse: MainDataResponse): MainData {
    return MainData(
        mainDataResponse.after,
        mainDataResponse.dist,
        mapToChildren(mainDataResponse.children)
    )
}

fun mapToChildren(childrenResponse: List<ChildrenResponse>): List<Children> {
    return childrenResponse.map { Children(it.kind, mapToChildrenData(it.data)) }
}

fun mapToChildrenData(childrenDataResponse: ChildrenDataResponse): ChildrenData {
    return ChildrenData(0, childrenDataResponse.title)
}
