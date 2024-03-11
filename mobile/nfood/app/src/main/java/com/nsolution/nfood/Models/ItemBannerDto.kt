package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemBannerDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("image")
  @Expose
  var image: String? = null
}