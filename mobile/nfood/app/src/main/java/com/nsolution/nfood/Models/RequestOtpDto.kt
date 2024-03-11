package com.nsolution.nfood.Models

import com.google.gson.annotations.SerializedName

data class RequestOtpDto(
  @SerializedName("phonenumber")
  val phonenumber: String,
  @SerializedName("countryCode")
  val countryCode: String
)