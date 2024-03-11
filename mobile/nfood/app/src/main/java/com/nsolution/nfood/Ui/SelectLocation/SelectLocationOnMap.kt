package com.nsolution.nfood.Ui.SelectLocation

import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.mapbox.android.gestures.MoveGestureDetector
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Singleton.LocationSingleton
import com.nsolution.nfood.Ui.Base.BaseMapboxActivity
import java.util.*

class SelectLocationOnMap : BaseMapboxActivity() {
  
  private var mapView: MapView? = null
  private var currentLocation : LocationDto? = null
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    getInstanceMapbox()
    
    setContentView(R.layout.activity_select_location_on_map)
    initialView(savedInstanceState)
  
    LocationSingleton.instance.data.observe(this, Observer {
      getMap(it)
      updateUI(it)
      updateCurrentLocation(it)
    })
  }
  
  private fun initialView(savedInstanceState: Bundle?){
//    getBackActionBar(header,getString(R.string.select_on_map))
//
//    mapView = findViewById(R.id.mapView)
//    mapView?.onCreate(savedInstanceState)
//    getMapView(mapView)
//
//    confirmLocationButton.setOnClickListener {
//      confirmLocationButtonHandle()
//    }
  }
  
  private fun getMap(location : LocationDto?){
    mapView?.getMapAsync { mapboxMap ->
      setupMapStyle(mapboxMap)
      moveCamera(location)
      mapboxMap.addOnCameraIdleListener(object : MapboxMap.OnCameraIdleListener {
        override fun onCameraIdle() {
          val newLocation = getTargetMapbox()
          updateCurrentLocation(newLocation)
          updateUI(newLocation)
        }
      })
    }
  }
  
  
  private fun getTargetMapbox() : LocationDto?{
    val mapLatLng = mapboxMap?.cameraPosition?.target
    val location = LocationDto()
    
    val shortAddress = getStreet(mapLatLng)
    val longAddress = getAddressDetail(mapLatLng)
    
    location.apply {
      address = shortAddress
      detailAddress = longAddress
      latitude = mapLatLng?.latitude
      longitude = mapLatLng?.longitude
    }
    
    return location
  }
  
  private fun updateLocationSingleton(location: LocationDto?) {
    LocationSingleton.instance.updateData(location)
  }
  
  private fun getStreet(latLng: LatLng?) : String? {
    if(latLng != null){
      val geoLocation  = getGeoLocation(latLng)
      val indexStreet = geoLocation?.featureName
      val street = geoLocation?.thoroughfare
      return indexStreet + " " + street
    }
    return null
  }
  
  private fun getAddressDetail(latLng: LatLng?) : String? {
    val geoLocation  = getGeoLocation(latLng)
    return geoLocation?.getAddressLine(0)
  }
  
  private fun getGeoLocation(latLng: LatLng?): Address? {
    val geocoder = Geocoder(this)
    try {
      
      val resultAddress =
        geocoder.getFromLocation(latLng?.latitude!!, latLng.longitude, 1)
      
      if(resultAddress != null && resultAddress.isNotEmpty()) {
        return resultAddress.get(0)
      }
      
    } catch (exception : Exception) {
//      street.visibility = View.INVISIBLE
//      addressDetail.visibility = View.INVISIBLE
      exception.printStackTrace()
    }
    return null
  }
  
  private fun updateCurrentLocation(location : LocationDto?){
    if(location != null) {
      currentLocation = location
    }
  }
  
  private fun updateUI(location : LocationDto?){
//    if(location != null){
//      val latlng = LatLng(location.latitude!!,location.longitude!!)
//      street.text = getStreet(latlng)
//      addressDetail.text = getAddressDetail(latlng)
//    } else {
//      street.visibility = View.GONE
//      addressDetail.visibility = View.GONE
//    }
  }
  
  private fun confirmLocationButtonHandle(){
    updateLocationSingleton(currentLocation)
    finish()
  }
  
  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
  }
}
