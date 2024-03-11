package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CartStateDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("isHaveCart")
  @Expose
  var isHaveCart: Boolean? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  
  @SerializedName("numberItems")
  @Expose
  var numberItems: Int? = null
  
  @SerializedName("cost")
  @Expose
  var cost: Double? = null
}