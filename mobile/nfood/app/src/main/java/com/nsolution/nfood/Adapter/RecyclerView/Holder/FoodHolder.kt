package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfood.R

class FoodHolder(itemView: View) : BaseHolder(itemView){
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodCost = itemView.findViewById<TextView>(R.id.foodCost)
  val foodImage = itemView.findViewById<ImageView>(R.id.foodImage)
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}