package com.nsolution.nfood.Ui.CustomView.CustomBottomSheet

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nsolution.nfood.R

open class BaseBottomSheetDialog : BottomSheetDialogFragment(){
  override fun getTheme(): Int {
    return R.style.FilterBottomSheetDialog
  }
  
  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    return BottomSheetDialog(requireContext(), theme)
  }
}