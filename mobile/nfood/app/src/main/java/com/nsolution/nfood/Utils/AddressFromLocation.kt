package com.nsolution.nfood.Utils

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import com.mapbox.mapboxsdk.geometry.LatLng

class AddressFromLocation(val context : Context?) {
  
  fun getStreet(location: Location?): String? {
    val geoLocation = getGeoLocation(location)
    if (geoLocation != null) {
      val indexStreet = geoLocation.featureName
      val street = geoLocation.thoroughfare
      
      if (indexStreet != null || street != null)
        return indexStreet + " " + street
    }
    return null
  }
  
  fun getAddressDetail(location: Location?): String? {
    val geoLocation = getGeoLocation(location)
    return geoLocation?.getAddressLine(0)
  }
  
  fun getGeoLocation(location: Location?): Address? {
    val latLng = LatLng(location)
//    val geocoder = Geocoder(context)
//    try {
//      val resultAddress =
//        geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
//      if (resultAddress != null && resultAddress.isNotEmpty())
//        return resultAddress.get(0)
//    } catch (exception: Exception) {
//      exception.printStackTrace()
//      return null
//    }
    return null
  }
}