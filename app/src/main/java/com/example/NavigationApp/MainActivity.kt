package com.example.NavigationApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.Menu

import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.NavigationApp.adapter.PlacesAdapter
import com.example.NavigationApp.api.ApiService

import com.example.NavigationApp.model.Feature
import com.example.NavigationApp.model.Place

import com.example.NavigationApp.model.PlacesName
import com.example.NavigationApp.map.MapsActivity

import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// View.OnClickListener//
class MainActivity : AppCompatActivity(), IOnclickListener {

    lateinit var adapter: PlacesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchApi()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchIcon = menu?.findItem(R.id.places_search)
        val searchView = searchIcon?.actionView as SearchView
        if (this@MainActivity::adapter.isInitialized)

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    adapter.filter.filter(query)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }
            })
        return super.onCreateOptionsMenu(menu)
    }


    private fun fetchApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.noforeignland.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.getPlaces().enqueue(object : Callback<PlacesName> {

            override fun onResponse(call: Call<PlacesName>, response: Response<PlacesName>) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<PlacesName>, t: Throwable) {
                d("API", "onFailure: $t")
            }
        })
    }


    private fun showData(places: PlacesName) {
        val placeList = places.features
        recycler_view.also {
            it.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PlacesAdapter(placeList, this)
            it.adapter = adapter
            invalidateOptionsMenu()
        }
    }

    override fun onItemClick(id: String) {
        val intent = Intent(this, LoadPlaceActivity::class.java).apply {
           putExtra("placeId", id)
        }
        startActivity(intent)
    }

    override fun onIconClick(lat: Double, lon: Double) {
        val intent = Intent(this, MapsActivity::class.java).also{
            it.putExtra("lat", lat)
            it.putExtra("lon", lon)
        }
        startActivity(intent)
    }



}








