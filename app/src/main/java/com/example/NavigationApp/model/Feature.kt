package com.example.NavigationApp.model


import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Feature(
    val geometry: Geometry,
    val properties: Properties,
    val type: String
) : Parcelable