package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemVoucherDto {
  @SerializedName("voucherId")
  @Expose
  var voucherId: Int? = null
  
  @SerializedName("voucherTitle")
  @Expose
  var voucherTitle: String? = null
  
  @SerializedName("voucherImage")
  @Expose
  var voucherImage: String? = null
  
  @SerializedName("voucherSubtitle")
  @Expose
  var voucherSubtitle: String? = null
  
  @SerializedName("voucherMinOrderPrice")
  @Expose
  var voucherMinOrderPrice: String? = null
  
  @SerializedName("voucherIsAlmostOverData")
  @Expose
  var voucherIsAlmostOverData: Boolean? = null
  
  @SerializedName("voucherStatus")
  @Expose
  var voucherStatus: String? = null
}