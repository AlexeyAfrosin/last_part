package com.afrosin.lastpart.mvp.repo

import com.afrosin.lastpart.mvp.api.RedditApi
import com.afrosin.lastpart.mvp.exception.NoInternetException
import com.afrosin.lastpart.mvp.model.HotPostListing
import com.afrosin.lastpart.mvp.network.NetworkStatus
import com.afrosin.lastpart.utils.mapToHotPostListing
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ApiRepo(val api: RedditApi, val networkStatus: NetworkStatus) {

    fun getHotPosts(count: Int, after: String): Single<HotPostListing> =
        networkStatus
            .isOnlineSingle()
            .flatMap { isOnline ->
                if (isOnline) {
                    api
                        .getHotPosts(count, after)
                        .flatMap { hotPostApiResponse ->
                            Single.just(mapToHotPostListing(hotPostApiResponse))
                        }
                } else {
                    Single.error(NoInternetException())
                }
            }
            .subscribeOn(Schedulers.io())

}