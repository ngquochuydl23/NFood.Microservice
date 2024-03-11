package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfood.R

class MyFavouriteHolder(val itemView: View) : BaseHolder(itemView) {
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurantImage)
  val restaurantAddress = itemView.findViewById<TextView>(R.id.restaurantAddress)
  val restaurantWorkTime = itemView.findViewById<TextView>(R.id.restaurantWorkTime)
  val listFavouriteFood = itemView.findViewById<RecyclerView>(R.id.listFavouriteFood)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}