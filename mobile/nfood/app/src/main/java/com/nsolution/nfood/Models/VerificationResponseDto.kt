package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VerificationResponseDto {
  @SerializedName("authToken")
  @Expose
  val authToken: String? = null
  
  @SerializedName("account")
  @Expose
  val account: AccountDto? = null
}