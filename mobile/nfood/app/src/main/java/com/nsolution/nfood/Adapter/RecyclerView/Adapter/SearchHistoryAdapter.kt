package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.SearchHistoryHolder
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SearchHistorySharedPreferences

class SearchHistoryAdapter(val listSearchHistory: ArrayList<String>?) :
  BaseAdapter<SearchHistoryHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryHolder {
    val view = getView(parent, viewType, R.layout.item_search_history)
    return SearchHistoryHolder(view)
  }
  
  override fun onBindViewHolder(holder: SearchHistoryHolder, position: Int) {
    val itemSearchHistory = listSearchHistory?.get(position)
    
    holder.searchHistoryText.text = itemSearchHistory
    holder.searchHistoryDelete.setOnClickListener {
      removeItemAt(listSearchHistory, position)
      SearchHistorySharedPreferences(context).removeItemAt(position)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listSearchHistory)
  }
}