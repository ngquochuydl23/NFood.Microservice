package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HomeContentDto {
  @SerializedName("listBanner")
  @Expose
  var listBanner: ArrayList<ItemBannerDto>? = null
  
  @SerializedName("listCategory")
  @Expose
  var listCategory: ArrayList<ItemCategoryDto>? = null
  
  @SerializedName("listHome")
  @Expose
  var listHome: ArrayList<ItemListHomeDto>? = null
  
  @SerializedName("moreRestaurant")
  @Expose
  var moreRestaurant: ArrayList<ItemRestaurantVertiDto>? = null
}