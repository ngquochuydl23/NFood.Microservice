package com.nsolution.nfood.SharedReferences

import android.content.Context
import com.google.gson.Gson

class SearchHistorySharedPreferences(context: Context) :
  BaseSharedPreferences<ArrayList<String>?>(context) {
  
  private val FIRST_ELEMENT = 0
  private val SEARCH_HISTORY_SHARE_PREFERENCES = "SEARCH_HISTORY_SHARE_PREFERENCES"
  private var listSearchHistory : ArrayList<String>? = null
  
  override fun setName(): String = SEARCH_HISTORY_SHARE_PREFERENCES
  
  override fun getData(): ArrayList<String>? {
    val data = sharedPreferences?.getString(SEARCH_HISTORY_SHARE_PREFERENCES, null)
    println(data)
    return Gson().fromJson(data, arrayListOf<String>()::class.java)
  }
  
  override fun setData(data: ArrayList<String>?) {
    editor.putString(SEARCH_HISTORY_SHARE_PREFERENCES, Gson().toJson(data)).commit()
  }
  
  fun addSearchHistory(data: String) {
    listSearchHistory = getData()
    if(listSearchHistory.isNullOrEmpty()) {
      listSearchHistory = arrayListOf()
    }
    listSearchHistory?.add(data)
    if(listSearchHistory?.size!! >= 5) {
      listSearchHistory?.removeAt(FIRST_ELEMENT)
    }
    setData(listSearchHistory)
    println(getData())
  }
  
  fun removeItemAt(position: Int){
    listSearchHistory = getData()
    if(listSearchHistory.isNullOrEmpty()) {
      listSearchHistory?.removeAt(position)
      setData(listSearchHistory)
    }
  }
  
  override fun deleteData() {
    editor.clear().apply()
  }
}