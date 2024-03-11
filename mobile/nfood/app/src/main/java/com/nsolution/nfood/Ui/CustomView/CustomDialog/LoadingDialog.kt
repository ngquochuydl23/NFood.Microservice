package com.nsolution.nfood.Ui.CustomView.CustomDialog

import android.content.Context
import com.nsolution.nfood.R

open class LoadingDialog(context: Context?) : BaseDialog(context){
  
  override fun createDialog() {
    super.createDialog()
    setContentView(R.layout.layout_loading)
    setCanceledOnTouchOutside(false)
  }
}