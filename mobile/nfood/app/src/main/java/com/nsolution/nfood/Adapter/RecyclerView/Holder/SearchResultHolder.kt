package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class SearchResultHolder(itemView: View) : BaseHolder(itemView) {
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val restaurantType = itemView.findViewById<TextView>(R.id.restaurantType)
  val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurantImage)
  val iconRate = itemView.findViewById<View>(R.id.iconRate)
  val restaurantRate = itemView.findViewById<TextView>(R.id.restaurantRate)
  val deliveryTimeAndDistance = itemView.findViewById<TextView>(R.id.deliveryTimeAndDistance)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}