package com.example.NavigationApp.model


import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@SuppressLint("ParcelCreator")
@Parcelize

data class PlacesName(
    val features: List<Feature>,
    val type: String
) : Parcelable