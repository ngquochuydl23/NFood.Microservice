package com.nsolution.nfood.SharedReferences

import android.content.Context
import com.google.gson.Gson
import com.nsolution.nfood.Models.LocationDto

class LocationOfDeviceSharedPreferences(context: Context?) : BaseSharedPreferences<LocationDto?>(context) {
  
  private val Account_SharedPreferences = "LocationOfDevice_SharedPreferences"
  
  override fun setName(): String = Account_SharedPreferences
  
  override fun setData(data: LocationDto?) {
    editor.putString(Account_SharedPreferences, Gson().toJson(data)).commit()
  }
  
  override fun getData(): LocationDto? {
    val result = sharedPreferences?.getString(Account_SharedPreferences, null)
    if (result != null && result.isNotEmpty())
      return Gson().fromJson(result, LocationDto::class.java)
    return null
  }
  
  override fun deleteData() {
    editor.clear().apply()
  }
}