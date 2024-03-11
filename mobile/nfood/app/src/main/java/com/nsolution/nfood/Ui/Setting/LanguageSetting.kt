package com.nsolution.nfood.Ui.Setting

import android.os.Bundle
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class LanguageSetting : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_language_setting)
    initialView()
  }
  
  private fun initialView() {
    //getBackActionBar(header, getString(R.string.language_setting))
  }
}
