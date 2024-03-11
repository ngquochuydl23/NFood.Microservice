package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMenuParentDto {
  @SerializedName("menuId")
  @Expose
  var menuId: Int? = null
  
  @SerializedName("menuTitle")
  @Expose
  var menuTitle: String? = null
  
  @SerializedName("listFood")
  @Expose
  var listFood: ArrayList<ItemMenuChildDto>? = null
}