package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AskJoinGroupDto {
  @SerializedName("groupId")
  @Expose
  var groupId: Int? = null
  
  @SerializedName("owner")
  @Expose
  var owner: MemberOrderGroupDto? = null
  
  @SerializedName("listMember")
  @Expose
  var listMember: ArrayList<MemberOrderGroupDto>? = null
  
  @SerializedName("address")
  @Expose
  var address: String? = null
  
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
}