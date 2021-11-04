package com.cerengumus.horoscopeapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
    var zodiacName: String,
    var image: Int
):Parcelable
