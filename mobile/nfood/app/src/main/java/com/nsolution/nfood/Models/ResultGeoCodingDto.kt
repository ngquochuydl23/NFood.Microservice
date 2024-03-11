package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultGeoCodingDto {
  @SerializedName("results")
  @Expose
  var results: ArrayList<ItemGeoCodingDto>? = null
}