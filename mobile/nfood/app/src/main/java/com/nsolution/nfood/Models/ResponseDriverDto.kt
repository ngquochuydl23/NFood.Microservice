package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseDriverDto {
  @SerializedName("driverId")
  @Expose
  var driverId: Int? = null
  
  @SerializedName("driverName")
  @Expose
  var driverName: String? = null
  
  @SerializedName("driverAvatar")
  @Expose
  var driverAvatar: String? = null
  
  @SerializedName("driverRate")
  @Expose
  var driverRate: Double? = null
  
  @SerializedName("driverMotor")
  @Expose
  var driverMotor: String? = null
}