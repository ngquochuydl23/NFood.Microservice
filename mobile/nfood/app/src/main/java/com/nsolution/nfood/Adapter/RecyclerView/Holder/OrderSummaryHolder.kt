package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfood.R

class OrderSummaryHolder(val itemView: View) : BaseHolder(itemView) {
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodAttribute = itemView.findViewById<TextView>(R.id.foodAttribute)
  val foodCost = itemView.findViewById<TextView>(R.id.foodCost)
  val quanlity = itemView.findViewById<TextView>(R.id.quanlity)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}