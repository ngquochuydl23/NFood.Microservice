package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import com.nsolution.nfood.R

class AttributeChildHolder(itemView: View) : BaseHolder(itemView){
  val attributeName = itemView.findViewById<TextView>(R.id.attributeName)
  val attributePrice = itemView.findViewById<TextView>(R.id.attributePrice)
  val selectButton = itemView.findViewById<View>(R.id.selectButton)
  val isSelected = itemView.findViewById<RadioButton>(R.id.isSelected)
}