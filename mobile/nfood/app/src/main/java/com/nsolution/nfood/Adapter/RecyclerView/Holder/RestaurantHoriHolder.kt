package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class RestaurantHoriHolder(itemView: View) : BaseHolder(itemView){
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurantImage)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}