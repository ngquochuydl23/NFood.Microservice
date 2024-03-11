package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccountDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("phonenumber")
  @Expose
  var phonenumber: String? = null
  
  @SerializedName("createdOn")
  @Expose
  var createdOn: String? = null
  
  @SerializedName("lastLogin")
  @Expose
  var lastLogin: String? = null
  
  @SerializedName("profile")
  @Expose
  var profile: ProfileDto? = null
}