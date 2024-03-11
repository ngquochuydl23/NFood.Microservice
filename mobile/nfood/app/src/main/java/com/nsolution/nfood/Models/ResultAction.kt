package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultAction<T> {
  @SerializedName("result")
  @Expose
  var result: T? = null
  
  @SerializedName("statusCode")
  @Expose
  var statusCode: Int? = null
}