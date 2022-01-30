package com.direnaydin.arabamcom.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val cityName: String,
    val townName: String
) : Parcelable