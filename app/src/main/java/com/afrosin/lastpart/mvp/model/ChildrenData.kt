package com.afrosin.lastpart.mvp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "children_datas")
data class ChildrenData(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String
) : Parcelable