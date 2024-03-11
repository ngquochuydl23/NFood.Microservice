package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfood.R

class AttributeParentHolder(itemView: View) : BaseHolder(itemView){
  val attributeParentName = itemView.findViewById<TextView>(R.id.attributeParentName)
  val attributeType = itemView.findViewById<TextView>(R.id.attributeType)
  val attributeMaxSelect = itemView.findViewById<TextView>(R.id.attributeMaxSelect)
  val listAttributeChild = itemView.findViewById<RecyclerView>(R.id.listAttributeChild)
}