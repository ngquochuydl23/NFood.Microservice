package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProfileDto {
  @SerializedName("accountId")
  @Expose
  var accountId: Int? = null
  
  @SerializedName("fullname")
  @Expose
  var fullname: String? = null
  
  @SerializedName("avatar")
  @Expose
  var avatar: String? = null
  
  @SerializedName("email")
  @Expose
  var email: String? = null
  
  
  @SerializedName("active")
  @Expose
  var active: Boolean? = null
}