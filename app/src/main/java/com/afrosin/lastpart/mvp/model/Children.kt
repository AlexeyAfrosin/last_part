package com.afrosin.lastpart.mvp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Children(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("data")
    val data: ChildrenData
) : Parcelable