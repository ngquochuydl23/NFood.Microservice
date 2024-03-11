package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class CollectionHolder(val itemView : View) : BaseHolder(itemView) {
  val collectionImage = itemView.findViewById<ImageView>(R.id.collectionImage)
  val collectionTitle = itemView.findViewById<TextView>(R.id.collectionTitle)
  val collectionSubtitle = itemView.findViewById<TextView>(R.id.collectionSubtitle)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}