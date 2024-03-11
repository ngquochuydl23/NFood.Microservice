package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemRestaurantVertiDto {
  @SerializedName("restaurantId")
  @Expose
  var restaurantId: Int? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  
  @SerializedName("restaurantImage")
  @Expose
  var restaurantImage: String? = null
  
  @SerializedName("restaurantType")
  @Expose
  var restaurantType: String? = null
  
  @SerializedName("restaurantRate")
  @Expose
  var restaurantRate: Double? = null
  
  @SerializedName("deliveryTime")
  @Expose
  var deliveryTime: Double? = null
  
  @SerializedName("distance")
  @Expose
  var distance: Double? = null
}