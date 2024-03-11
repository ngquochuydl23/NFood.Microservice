package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemCategoryDto {
  @SerializedName("categoryId")
  @Expose
  var categoryId: Int? = null
  
  @SerializedName("title")
  @Expose
  var title: String? = null
  
  @SerializedName("image")
  @Expose
  var image: String? = null
}