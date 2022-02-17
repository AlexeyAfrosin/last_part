package com.afrosin.lastpart.mvp.network

import io.reactivex.rxjava3.core.Single

interface NetworkStatus {
    fun isOnlineSingle(): Single<Boolean>
}