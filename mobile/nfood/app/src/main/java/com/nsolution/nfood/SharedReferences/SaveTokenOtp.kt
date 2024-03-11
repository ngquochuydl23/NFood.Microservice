package com.nsolution.nfood.SharedReferences

import android.content.Context

class SaveTokenOtp(context: Context?) : BaseSharedPreferences<String?>(context) {
  
  companion object {
    val tokenName = "Token"
    val tokenOtpName = "tokenOtpName"
  }
  
  override fun setName(): String = tokenOtpName
  
  override fun getData(): String? {
    return sharedPreferences?.getString(tokenName, null)
  }
  
  override fun setData(data: String?) {
    editor.putString(tokenName, data).commit()
  }
  
  override fun deleteData() {
    editor.clear().apply()
  }
}