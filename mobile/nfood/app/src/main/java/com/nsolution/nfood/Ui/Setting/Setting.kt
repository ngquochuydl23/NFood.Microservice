package com.nsolution.nfood.Ui.Setting

import android.os.Bundle
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity

class Setting : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setting)
    initialView()
  }
  
  private fun initialView() {
//    getBackActionBar(header, getString(R.string.setting))
//
//    updateProfileButton.setOnClickListener {
//      navigateTo(UpdateProfile::class.java)
//    }
//
//    notificationSettingButton.setOnClickListener {
//      navigateTo(NotificationSetting::class.java)
//    }
//
//    languageSettingButton.setOnClickListener {
//      navigateTo(LanguageSetting::class.java)
//    }
  }
}
