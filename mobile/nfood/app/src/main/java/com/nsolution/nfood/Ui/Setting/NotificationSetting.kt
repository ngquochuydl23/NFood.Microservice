package com.nsolution.nfood.Ui.Setting

import android.os.Bundle
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class NotificationSetting : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_notification_setting)
    initialView()
  }
  
  private fun initialView() {
    //getBackActionBar(header, getString(R.string.notification_setting))
  }
}
