package com.nsolution.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemCollectionDto {
  @SerializedName("collectionId")
  @Expose
  var collectionId: Int? = null
  
  @SerializedName("collectionImage")
  @Expose
  var collectionImage: String? = null
  
  @SerializedName("collectionTitle")
  @Expose
  var collectionTitle: String? = null
  
  @SerializedName("collectionSubtitle")
  @Expose
  var collectionSubtitle: String? = null
}