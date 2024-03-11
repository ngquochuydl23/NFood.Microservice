package com.nsolution.nfood.Ui.CustomView.CustomDialog

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.annotation.LayoutRes
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView


open class BaseDialog(val context: Context?) {
  
  private var dialog: MaterialDialog? = null
  
  var view: View? = null
  
  fun setContentView(@LayoutRes layout: Int) {
    dialog?.customView(layout,dialogWrapContent = true,noVerticalPadding = true)
    this.view = dialog?.getCustomView()
  }
  
  fun showDialog() {
    dialog?.show()
  }
  
  open fun setCanceledOnTouchOutside(isCancel: Boolean) {
    dialog?.cancelOnTouchOutside(false)
  }
  
  @SuppressLint("ResourceType")
  open fun createDialog() {
    dialog = MaterialDialog(context!!)
    dialog?.cornerRadius(5f)
  }
  
  open fun dismiss() {
    dialog?.dismiss()
  }
}