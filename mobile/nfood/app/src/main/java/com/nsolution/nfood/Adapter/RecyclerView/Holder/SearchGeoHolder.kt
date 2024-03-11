package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class SearchGeoHolder(itemView: View) : BaseHolder(itemView) {
  val shortName = itemView.findViewById<TextView>(R.id.shortName)
  val formattedAddress = itemView.findViewById<TextView>(R.id.formattedAddress)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}