package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMenuChildDto {
  @SerializedName("foodId")
  @Expose
  var foodId: Int? = null
  
  @SerializedName("foodName")
  @Expose
  var foodName: String? = null
  
  @SerializedName("foodImage")
  @Expose
  var foodImage: String? = null
  
  @SerializedName("foodIntroduce")
  @Expose
  var foodIntroduce: String? = null
  
  @SerializedName("foodCost")
  @Expose
  var foodCost: Double? = null
}