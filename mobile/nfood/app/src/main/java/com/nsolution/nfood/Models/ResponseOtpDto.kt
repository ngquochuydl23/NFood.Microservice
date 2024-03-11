package com.nsolution.nfood.Models

import com.google.gson.annotations.SerializedName

data class ResponseOtpDto(
  @SerializedName("resendTime")
  val resendTime: Int?,
  @SerializedName("message")
  val message: String?,
  @SerializedName("token")
  val token: String?
)