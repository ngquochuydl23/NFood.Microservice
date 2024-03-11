package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfood.R

class MenuParentHolder(itemView: View) : BaseHolder(itemView){
  val menuTitle = itemView.findViewById<TextView>(R.id.menuTitle)
  val listFood = itemView.findViewById<RecyclerView>(R.id.listFood)
}