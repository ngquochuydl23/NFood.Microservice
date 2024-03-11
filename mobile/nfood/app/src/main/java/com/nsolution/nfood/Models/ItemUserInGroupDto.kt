package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemUserInGroupDto {
  @SerializedName("userId")
  @Expose
  var userId: Int? = null
  
  @SerializedName("userAvatar")
  @Expose
  var userAvatar: String? = null
}