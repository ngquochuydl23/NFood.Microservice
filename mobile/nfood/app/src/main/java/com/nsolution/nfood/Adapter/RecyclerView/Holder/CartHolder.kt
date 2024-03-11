package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class CartHolder(itemView : View): BaseHolder(itemView){
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodCost = itemView.findViewById<TextView>(R.id.foodCost)
  val foodImage = itemView.findViewById<ImageView>(R.id.foodImage)
  val foodAttributes = itemView.findViewById<TextView>(R.id.foodAttributes)
  val foodQuanlity = itemView.findViewById<TextView>(R.id.foodQuanlity)
  val decreaseClick = itemView.findViewById<Button>(R.id.decreaseClick)
  val increaseClick = itemView.findViewById<Button>(R.id.increaseClick)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}