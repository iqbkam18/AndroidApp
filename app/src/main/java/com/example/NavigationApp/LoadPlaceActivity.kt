package com.example.NavigationApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.core.text.HtmlCompat
import com.example.NavigationApp.api.ApiService
import com.example.NavigationApp.map.MapsActivity
import com.example.NavigationApp.model.PlaceDetailsApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_load_place.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoadPlaceActivity() : AppCompatActivity(){

    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_place)
        id = intent.getStringExtra("placeId")
        getDetails()
    }

    private fun getDetails() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.noforeignland.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)
        api.getDetails(id).enqueue(object : Callback<PlaceDetailsApi> {
            override fun onFailure(call: Call<PlaceDetailsApi>, t: Throwable) {
                Log.d("API", "onFailure: $t")
            }

            override fun onResponse(
                call: Call<PlaceDetailsApi>,
                response: Response<PlaceDetailsApi>
            ) {
                Log.d("API", "onFailure: $response")
                showData(response.body()!!)
            }

        })


    }

    private fun showData(places: PlaceDetailsApi) {
        place_name.text = places.place.name

        icon_location.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.apply {
                putExtra("lon", places.place.lat)
                putExtra("lat", places.place.lon)
            }
            startActivity(intent)
        }
        //To ""hide" the html tags
        if (places.place.comments.isNotEmpty())
            place_details.text = HtmlCompat.fromHtml(
                places.place.comments, HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        //place_details.text = places.place.comments
        if (places.place.banner.isEmpty()) {
            return
        } else {
            Picasso.get().load(places.place.banner).into(place_photo)
        }

    }







}





