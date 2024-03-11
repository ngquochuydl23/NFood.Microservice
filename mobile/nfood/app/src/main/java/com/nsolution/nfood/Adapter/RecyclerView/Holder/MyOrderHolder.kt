package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class MyOrderHolder(val itemView: View) : BaseHolder(itemView) {
  val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
  val restaurantImage = itemView.findViewById<ImageView>(R.id.restaurantImage)
  val numberItemAndPrice = itemView.findViewById<TextView>(R.id.numberItemAndPrice)
  val orderTime = itemView.findViewById<TextView>(R.id.orderTime)
  val orderId = itemView.findViewById<TextView>(R.id.orderId)
  val orderStatus = itemView.findViewById<TextView>(R.id.orderStatus)
  val orderAgainButton = itemView.findViewById<Button>(R.id.orderAgainButton)
  val cancelOrderButton = itemView.findViewById<Button>(R.id.cancelOrderButton)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}