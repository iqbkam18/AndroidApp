package com.example.NavigationApp.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
@Entity(tableName ="Place")
data class Place(
    @SerializedName("name")
    val name: String,
    @SerializedName("banner")
    val banner: String,
    @SerializedName("comments")
    val comments: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
) : Parcelable