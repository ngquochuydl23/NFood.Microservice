package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemOrderSummaryDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("foodName")
  @Expose
  var foodName: String? = null
  
  @SerializedName("foodAttributes")
  @Expose
  var foodAttributes: String? = null
  
  @SerializedName("foodCost")
  @Expose
  var foodCost: Double? = null
  
  @SerializedName("quanlity")
  @Expose
  var quanlity: Int? = null
}