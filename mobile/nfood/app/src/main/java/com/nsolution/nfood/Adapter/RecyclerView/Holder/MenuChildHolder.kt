package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import com.nsolution.nfood.R

class MenuChildHolder(itemView: View) : BaseHolder(itemView) {
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodImage = itemView.findViewById<ImageView>(R.id.foodImage)
  val foodIntroduce = itemView.findViewById<TextView>(R.id.foodIntroduce)
  val foodCost = itemView.findViewById<TextView>(R.id.foodCost)
  val foodFavourite = itemView.findViewById<RadioButton>(R.id.foodFavourite)
  val addToCart = itemView.findViewById<Button>(R.id.addToCart)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}