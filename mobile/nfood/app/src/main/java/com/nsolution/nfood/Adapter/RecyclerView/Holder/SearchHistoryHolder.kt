package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfood.R

class SearchHistoryHolder(itemView : View) : BaseHolder(itemView) {
  val searchHistoryText = itemView.findViewById<TextView>(R.id.searchHistoryText)
  val searchHistoryDelete = itemView.findViewById<View>(R.id.searchHistoryDelete)
}