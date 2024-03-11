package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfood.R

class ListHomeHolder(itemView: View) : BaseHolder(itemView) {
  val title = itemView.findViewById<TextView>(R.id.title)
  val subtitle = itemView.findViewById<TextView>(R.id.subtitle)
  val seeAll = itemView.findViewById<View>(R.id.seeAll)
  val listHome = itemView.findViewById<RecyclerView>(R.id.listHome)
}