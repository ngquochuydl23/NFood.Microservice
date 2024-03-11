package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemAttributeChildDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("attributeName")
  @Expose
  var attributeName: String? = null
  
  @SerializedName("attributePrice")
  @Expose
  var attributePrice: Double? = null
  
  @SerializedName("isSelected")
  @Expose
  var isSelected: Boolean? = null
}