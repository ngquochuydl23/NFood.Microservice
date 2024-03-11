package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemRestaurantHoriDto {
  @SerializedName("restaurantId")
  @Expose
  var restaurantId: Int? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  
  @SerializedName("restaurantImage")
  @Expose
  var restaurantImage: String? = null
}