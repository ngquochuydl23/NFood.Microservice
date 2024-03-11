package com.nsolution.nfood.Ui.CustomView.CustomBottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfood.R

open class HelpDriverBottomSheet : BaseBottomSheetDialog() {
  
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return LayoutInflater.from(context).inflate(R.layout.layout_bottomsheet_help_driver, container)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}