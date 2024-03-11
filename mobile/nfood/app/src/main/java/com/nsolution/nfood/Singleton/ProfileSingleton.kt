package com.nsolution.nfood.Singleton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nsolution.nfood.Models.AccountDto

class ProfileSingleton private constructor() {
  
  private object Holder {
    val INSTANT = ProfileSingleton()
  }
  
  companion object {
    val instance: ProfileSingleton by lazy { Holder.INSTANT }
  }
  
  private val resultLiveData = MutableLiveData<AccountDto>()
  
  var profile : LiveData<AccountDto> = resultLiveData
  
  fun updateData(newProfile : AccountDto?) {
    resultLiveData.postValue(newProfile)
  }
  
  fun resetData(){
    resultLiveData.value = null
  }
}