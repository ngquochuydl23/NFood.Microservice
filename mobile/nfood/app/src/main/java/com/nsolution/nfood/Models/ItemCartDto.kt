package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemCartDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("foodId")
  @Expose
  var foodId: Int? = null
  
  @SerializedName("foodName")
  @Expose
  var foodName: String? = null
  
  @SerializedName("foodImage")
  @Expose
  var foodImage: String? = null
  
  @SerializedName("quanlity")
  @Expose
  var quanlity: Int? = null
  
  @SerializedName("foodAttributes")
  @Expose
  var foodAttributes: String? = null
  
  @SerializedName("cost")
  @Expose
  var cost: Double? = null
}