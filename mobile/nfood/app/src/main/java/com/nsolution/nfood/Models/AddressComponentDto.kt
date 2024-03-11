package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AddressComponentDto {
  @SerializedName("long_name")
  @Expose
  var long_name: String? = null
  
  @SerializedName("short_name")
  @Expose
  var short_name: String? = null
}