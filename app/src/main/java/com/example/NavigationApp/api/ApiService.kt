package com.example.NavigationApp.api


import com.example.NavigationApp.model.Place
import com.example.NavigationApp.model.PlaceDetailsApi
import com.example.NavigationApp.model.PlacesName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/home/api/v1/places")
    fun getPlaces(): Call<PlacesName>

     @GET ("/home/api/v1/place")
    fun getDetails(@Query("id")id:String?) : Call<PlaceDetailsApi>
}