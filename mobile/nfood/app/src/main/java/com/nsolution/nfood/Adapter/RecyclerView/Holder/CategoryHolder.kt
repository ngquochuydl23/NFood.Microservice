package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class CategoryHolder(val itemView : View) : BaseHolder(itemView){
  val title = itemView.findViewById<TextView>(R.id.title)
  val image = itemView.findViewById<ImageView>(R.id.image)
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
}