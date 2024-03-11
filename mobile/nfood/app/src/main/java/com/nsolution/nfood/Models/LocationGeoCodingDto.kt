package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LocationGeoCodingDto {
  @SerializedName("lat")
  @Expose
  var lat: Double? = null
  
  @SerializedName("lng")
  @Expose
  var lng: Double? = null
}