package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemListHomeDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("title")
  @Expose
  var title: String? = null
  
  @SerializedName("subtitle")
  @Expose
  var subtitle: String? = null
  
  @SerializedName("type")
  @Expose
  var type: String? = null
  
  @SerializedName("listFood")
  @Expose
  var listFood: ArrayList<ItemFoodDto>? = null
  
  @SerializedName("listRestaurant")
  @Expose
  var listRestaurant : ArrayList<ItemRestaurantHoriDto>? = null
  
  @SerializedName("listCollection")
  @Expose
  var listCollection : ArrayList<ItemCollectionDto>? = null
}