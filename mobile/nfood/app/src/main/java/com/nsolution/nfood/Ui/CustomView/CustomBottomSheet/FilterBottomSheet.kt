package com.nsolution.nfood.Ui.CustomView.CustomBottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.nsolution.nfood.R


class FilterBottomSheet : BaseBottomSheetDialog() {
  
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return LayoutInflater.from(context).inflate(R.layout.layout_bottomsheet_filter, container)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setHeader()
    
//    applyButton.setOnClickListener {
//      this.dismiss()
//    }
  }
  
  private fun setHeader() {
//    val toolbar = header.findViewById<Toolbar>(R.id.toolbar)
//
//    header.findViewById<TextView>(R.id.headerTitle).text = getString(R.string.filter)
//    toolbar.setNavigationIcon(R.drawable.icon_close)
//    toolbar.setNavigationOnClickListener {
//     this.dismiss()
//    }
  }
}