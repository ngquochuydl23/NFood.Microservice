package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMyFavouriteDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("restaurantId")
  @Expose
  var restaurantId: Int? = null
  
  @SerializedName("restaurantImage")
  @Expose
  var restaurantImage: String? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  
  @SerializedName("restaurantAddress")
  @Expose
  var restaurantAddress: String? = null
  
  @SerializedName("restaurantWorkTime")
  @Expose
  var restaurantWorkTime: String? = null
  
  @SerializedName("listFavouriteFood")
  @Expose
  var listFavouriteFood: ArrayList<ItemMenuChildDto>? = null
}