package com.example.NavigationApp.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.NavigationApp.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps2)
        val extras = intent.extras
        latitude = extras!!.getDouble("lat")
        longitude = extras.getDouble("lon")
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val placeOnMap = LatLng(longitude, latitude)
        mMap.addMarker(MarkerOptions().position(placeOnMap))
        val camera = CameraUpdateFactory.newLatLngZoom(
            LatLng(
                longitude,
                latitude
            ), 14F
        )
        mMap.moveCamera(camera)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = getMenuInflater()
        inflater.inflate(R.menu.map_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        // Change the map type based on the user's selection.
        when (item.getItemId()) {
            R.id.normal_map -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                return true
            }
            R.id.hybrid_map -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID)
                return true
            }
            R.id.satellite_map -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE)
                return true
            }
            R.id.terrain_map -> {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


}

