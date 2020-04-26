package com.example.NavigationApp.model


import com.google.gson.annotations.SerializedName



data class PlaceDetailsApi(
    @SerializedName ("place")
    val place: Place,
    val snapshots: List<Snapshot>
)