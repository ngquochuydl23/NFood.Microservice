package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import com.nsolution.nfood.R

class UserInGroupHolder(val itemView : View) : BaseHolder(itemView) {
  val userAvatar = itemView.findViewById<ImageView>(R.id.userAvatar)
}