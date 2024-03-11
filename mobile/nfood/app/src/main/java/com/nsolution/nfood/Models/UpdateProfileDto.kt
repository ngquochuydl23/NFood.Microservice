package com.nsolution.nfood.Models

import com.google.gson.annotations.SerializedName

data class UpdateProfileDto(
  @SerializedName("phonenumber")
  val phonenumber: String?,
  @SerializedName("fullname")
  val fullname: String?,
  @SerializedName("email")
  val email: String?,
  @SerializedName("avatar")
  val avatar: String?
)