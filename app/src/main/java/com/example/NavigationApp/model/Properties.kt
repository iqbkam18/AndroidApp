package com.example.NavigationApp.model


import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Properties(
    val icon: String,
    val id: String,
    val name: String
) : Parcelable