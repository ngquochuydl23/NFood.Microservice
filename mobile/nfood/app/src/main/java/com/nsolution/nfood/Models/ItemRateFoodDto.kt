package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemRateFoodDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("foodImage")
  @Expose
  var foodImage: String? = null
  
  @SerializedName("foodName")
  @Expose
  var foodName: String? = null
  
  @SerializedName("isLike")
  @Expose
  var isLike: Int? = null
}