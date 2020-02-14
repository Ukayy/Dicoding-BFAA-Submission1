package com.p.dicodingmovie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title: String = "",
    val description: String  = "",
    val poster: Int = 0,
    val releaseDate: String ="",
    val durationTime: String ="",
    val distributedBy: String =""
):Parcelable