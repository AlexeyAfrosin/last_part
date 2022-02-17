package com.afrosin.lastpart.mvp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainData(
    val after: String,
    val dist: Int,
    val children: List<Children>
) : Parcelable