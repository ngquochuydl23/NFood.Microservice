package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemFoodDto {
  @SerializedName("foodId")
  @Expose
    var foodId: Int? = null
  
  @SerializedName("foodName")
  @Expose
  var foodName: String? = null
  
  @SerializedName("foodImage")
  @Expose
  var foodImage: String? = null
  
  @SerializedName("foodCost")
  @Expose
  var foodCost: Double? = null
  
  @SerializedName("restaurantId")
  @Expose
  var restaurantId: Int? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
}