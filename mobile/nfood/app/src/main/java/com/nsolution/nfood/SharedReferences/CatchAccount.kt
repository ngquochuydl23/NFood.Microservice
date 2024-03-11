package com.nsolution.nfood.SharedReferences

import android.content.Context
import com.google.gson.Gson
import com.nsolution.nfood.Models.AccountDto

class CatchAccount(context: Context?) : BaseSharedPreferences<AccountDto>(context) {
  
  private val Account_SharedPreferences = "Account_SharedPreferences"
  
  override fun setName(): String = Account_SharedPreferences
  
  override fun setData(data: AccountDto) {
    editor.putString(Account_SharedPreferences, Gson().toJson(data)).commit()
  }
  
  override fun getData(): AccountDto? {
    val result = sharedPreferences?.getString(Account_SharedPreferences, null)
    if (result != null && result.isNotEmpty())
      return Gson().fromJson(result, AccountDto::class.java)
    return null
  }
  
  override fun deleteData() {
    editor.clear().apply()
  }
}