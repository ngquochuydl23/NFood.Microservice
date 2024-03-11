package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMyOrderDto {
  
  @SerializedName("orderId")
  @Expose
  var orderId: String? = null
  
  @SerializedName("restaurantImage")
  @Expose
  var restaurantImage: String? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  
  @SerializedName("orderStatus")
  @Expose
  var orderStatus: String? = null
  
  @SerializedName("itemNumbers")
  @Expose
  var itemNumbers: Int? = null
  
  @SerializedName("price")
  @Expose
  var price: Double? = null
  
  @SerializedName("orderTime")
  @Expose
  var orderTime: String? = null
  
  @SerializedName("restaurantId")
  @Expose
  var restaurantId: Int? = null
  
  @SerializedName("orderStatusType")
  @Expose
  var orderStatusType: String? = null
}