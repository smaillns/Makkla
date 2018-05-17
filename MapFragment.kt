package com.example.smail.projectmob


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.example.smail.projectmob.R.id.mapView
import com.example.smail.projectmob.R.id.mapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.example.smail.projectmob.R.layout.fragment_map
import com.google.android.gms.maps.SupportMapFragment
import com.example.smail.projectmob.R.layout.fragment_map
import com.example.smail.projectmob.R.id.mapView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.UiSettings
import com.google.android.gms.maps.model.MarkerOptions







/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() ,OnMapReadyCallback{

    var mapView: MapView? = null
    var map: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_map, container, false)

        mapView = view.findViewById<MapView>(R.id.mapView) as MapView
        mapView?.onCreate(savedInstanceState)
        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView?.getMapAsync(this)

        return view
    }


    private fun initializeMap() {
        if (map == null) {
            val mapFrag = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
            mapFrag.getMapAsync(this)
        }
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onPause() {
        mapView?.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mapView?.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map?.setMinZoomPreference(12f)

        map?.setIndoorEnabled(true)

        val uiSettings = map?.getUiSettings()
        uiSettings?.setIndoorLevelPickerEnabled(true)
        uiSettings?.setMyLocationButtonEnabled(true)
        uiSettings?.setMapToolbarEnabled(true)
        uiSettings?.setCompassEnabled(true)
        uiSettings?.setZoomControlsEnabled(false)

        val ny = LatLng(36.7525000, 3.0419700)

        val markerOptions = MarkerOptions()
        markerOptions.position(ny)
        map?.addMarker(markerOptions)
        map?.moveCamera(CameraUpdateFactory.newLatLng(ny))

    }

}// Required empty public constructor
