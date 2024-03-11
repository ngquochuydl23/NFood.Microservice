package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import com.nsolution.nfood.R

class WorkTimeHolder(itemView: View) : BaseHolder(itemView) {
  val dayOfWeek = itemView.findViewById<TextView>(R.id.dayOfWeek)
  val workTime = itemView.findViewById<TextView>(R.id.workTime)
}