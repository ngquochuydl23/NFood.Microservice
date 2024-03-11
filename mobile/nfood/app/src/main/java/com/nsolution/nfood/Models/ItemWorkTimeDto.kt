package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemWorkTimeDto {
  @SerializedName("dayOfWeek")
  @Expose
  var dayOfWeek: String? = null
  
  @SerializedName("workTime")
  @Expose
  var workTime: String? = null
}