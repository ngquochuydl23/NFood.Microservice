package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemAttributeParentDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("attributeParentName")
  @Expose
  var attributeParentName: String? = null
  
  @SerializedName("attributeType")
  @Expose
  var attributeType: String? = null
  
  @SerializedName("attributeMaxSelect")
  @Expose
  var attributeMaxSelect: Int? = null
  
  @SerializedName("listAttributeChild")
  @Expose
  var listAttributeChild: ArrayList<ItemAttributeChildDto>? = null
}