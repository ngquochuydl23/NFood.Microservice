package com.nsolution.nfood.Models

import com.google.gson.annotations.SerializedName

data class VerificationRequestDto(
  @SerializedName("OtpCode")
  val OtpCode: String?
)