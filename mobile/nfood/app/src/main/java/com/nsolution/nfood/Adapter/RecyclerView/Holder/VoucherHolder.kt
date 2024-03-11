package com.nsolution.nfood.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.R

class VoucherHolder(itemView: View) : BaseHolder(itemView) {
  val containerLayout = itemView.findViewById<View>(R.id.containerLayout)
  val voucherTitle = itemView.findViewById<TextView>(R.id.voucherTitle)
  val voucherImage = itemView.findViewById<ImageView>(R.id.voucherImage)
  val voucherSubtitle = itemView.findViewById<TextView>(R.id.voucherSubtitle)
  val voucherMinOrderPrice = itemView.findViewById<TextView>(R.id.voucherMinOrderPrice)
  val voucherStatus = itemView.findViewById<TextView>(R.id.voucherStatus)
  val voucherDetailButton = itemView.findViewById<TextView>(R.id.voucherDetailButton)
}