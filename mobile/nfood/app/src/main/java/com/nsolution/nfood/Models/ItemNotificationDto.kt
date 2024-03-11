package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemNotificationDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("title")
  @Expose
  var title: String? = null
  
  @SerializedName("avatar")
  @Expose
  var avatar: String? = null
  
  @SerializedName("subTitle")
  @Expose
  var subtitle: String? = null
  
  @SerializedName("createdOn")
  @Expose
  var createdOn: String? = null
}