package com.example.NavigationApp.model


import com.google.gson.annotations.SerializedName


data class Snapshot(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("time")
    val time: Long
)