package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfood.R

class OrderWithGroupHolder(val itemView : View) : BaseHolder(itemView) {
  val userName = itemView.findViewById<TextView>(R.id.userName)
  val userAvatar = itemView.findViewById<ImageView>(R.id.userAvatar)
  val numberItems = itemView.findViewById<TextView>(R.id.numberItems)
  val orderSummarys = itemView.findViewById<RecyclerView>(R.id.orderSummarys)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}