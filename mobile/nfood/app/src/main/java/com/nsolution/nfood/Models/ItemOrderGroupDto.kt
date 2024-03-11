package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemOrderGroupDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null
  
  @SerializedName("userName")
  @Expose
  var userName: String? = null
  
  @SerializedName("userAvatar")
  @Expose
  var userAvatar: String? = null
  
  @SerializedName("isRoomOwner")
  @Expose
  var isRoomOwner: Boolean? = null
  
  @SerializedName("isMe")
  @Expose
  var isMe : Boolean? = null
  
  @SerializedName("listFood")
  @Expose
  var listSummaryFood: ArrayList<ItemOrderSummaryDto>? = null
}