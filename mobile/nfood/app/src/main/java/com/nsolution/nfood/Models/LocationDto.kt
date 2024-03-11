package com.nsolution.nfood.Models

import android.location.Location
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LocationDto {
  @SerializedName("address")
  @Expose
  var address: String? = null
  
  @SerializedName("detailAddress")
  @Expose
  var detailAddress: String? = null
  
  @SerializedName("latitude")
  @Expose
  var latitude: Double? = null
  
  @SerializedName("longitude")
  @Expose
  var longitude: Double? = null
  
  
  companion object {
    fun convertLocationToLocationDto(location: Location?): LocationDto {
      return LocationDto().apply {
        latitude = location?.latitude
        longitude = location?.longitude
      }
    }
  
    fun convertLocationToLocationDto(
      location: Location?,
      shortAddress: String?,
      longAddress: String?
    ): LocationDto {
      return LocationDto().apply {
        address = shortAddress
        detailAddress = longAddress
        latitude = location?.latitude
        longitude = location?.longitude
      }
    }
  }
}