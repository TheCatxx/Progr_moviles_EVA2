package com.tecsupapp.d_marco

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity:  AppCompatActivity(), OnMapReadyCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        createMapFragment()

    }

    private fun createMapFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        try {
            val success = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.stylemap))
            if (success) {
                Log.v("GOOGLE_MAPS","Cargo Correctamente")
            } else {
                Log.v("GOOGLE_MAPS","NO Cargo Correctamente")
            }
        } catch (e: Resources.NotFoundException) {
            Log.v("GOOGLE_MAPS","ERROR: ", e)
        }



        val icon = BitmapDescriptorFactory.fromResource(R.drawable.restaurant)
        val positionMarkerDMarco = LatLng(-8.111396, -79.030075)
        googleMap.addMarker(
            MarkerOptions().position(positionMarkerDMarco)
                .title("Restaurant DMarco")
                .snippet("Local Principal en ciudad de Trujillo")
                .icon(icon)
        )

        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(positionMarkerDMarco, 18F), 4000, null
        )

        //BOTON DE ZOOM + O -
        googleMap.uiSettings.isZoomControlsEnabled = true

        //DESAHBILITAR EL GESTO DE ROTACION DE CAMARA DEL MAPA
        googleMap.uiSettings.isRotateGesturesEnabled = false

    }


}