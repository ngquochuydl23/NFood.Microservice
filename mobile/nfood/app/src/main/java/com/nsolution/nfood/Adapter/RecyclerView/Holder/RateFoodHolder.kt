package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class RateFoodHolder(val itemView: View) : BaseHolder(itemView) {
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodImage = itemView.findViewById<ImageView>(R.id.foodImage)
  val likeButton = itemView.findViewById<ImageView>(R.id.likeButton)
  val dislikeButton = itemView.findViewById<ImageView>(R.id.dislikeButton)
}