package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemGeoCodingDto {
  
  @SerializedName("address_components")
  @Expose
  var addressComponents: ArrayList<AddressComponentDto>? = null
  
  @SerializedName("formatted_address")
  @Expose
  var formattedAddress: String? = null
  
  @SerializedName("geometry")
  @Expose
  var geometry: GeoCoding? = null
  
  class GeoCoding {
    @SerializedName("location")
    @Expose
    var location: LocationGeoCodingDto? = null
  }
}