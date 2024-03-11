package com.nsolution.nfood.Models

import com.google.gson.annotations.SerializedName

data class RequestGeoCodingDto(
  @SerializedName("address")
  val address: String? = null
)