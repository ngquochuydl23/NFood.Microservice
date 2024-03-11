package com.nsolution.nfood.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nsolution.nfood.Models.RequestOtpDto

class RequestOtpViewModel : ViewModel() {
  
  var requestOtpViewModel = MutableLiveData<RequestOtpDto>()
  
  fun observerVerificationRequest() : LiveData<RequestOtpDto> {
    return requestOtpViewModel
  }
  
  fun setVerificationRequestViewModel(requestOtp: RequestOtpDto) {
    this.requestOtpViewModel.value = requestOtp
  }
  
  fun clearViewModel() {
    this.onCleared()
  }
}