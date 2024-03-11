package com.nsolution.nfood.Singleton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nsolution.nfood.Models.LocationDto

class LocationSingleton private constructor() {
  
  private object Holder {
    val INSTANT = LocationSingleton()
  }
  
  companion object {
    val instance: LocationSingleton by lazy { Holder.INSTANT }
  }
  
  private val resultLiveData = MutableLiveData<LocationDto>()
  
  var data : LiveData<LocationDto> = resultLiveData
  
  fun updateData(newData : LocationDto?) {
    resultLiveData.postValue(newData)
  }
  
  fun resetProfile(){
    resultLiveData.value = null
  }
}