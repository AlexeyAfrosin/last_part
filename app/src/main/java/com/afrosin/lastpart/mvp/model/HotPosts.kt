package com.afrosin.lastpart.mvp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HotPosts(
    val kind: String,
    val data: MainData
) : Parcelable