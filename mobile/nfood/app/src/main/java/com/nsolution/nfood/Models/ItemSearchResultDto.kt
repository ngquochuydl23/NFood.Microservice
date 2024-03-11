package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemSearchResultDto {
  @SerializedName("RestaurantId")
  @Expose
  var RestaurantId: Int? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  
  @SerializedName("restaurantType")
  @Expose
  var restaurantType: String? = null
  
  @SerializedName("restaurantImage")
  @Expose
  var restaurantImage: String? = null
  
  @SerializedName("restaurantRate")
  @Expose
  var restaurantRate: Double? = null
  
  @SerializedName("deliveryTimeAndDistance")
  @Expose
  var deliveryTimeAndDistance: String? = null
}