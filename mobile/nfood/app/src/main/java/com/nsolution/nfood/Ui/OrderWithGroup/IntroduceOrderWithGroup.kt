package com.nsolution.nfood.Ui.OrderWithGroup

import android.os.Bundle
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class IntroduceOrderWithGroup : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_introduce_order_with_group)
    initialView()
  }
  
  private fun initialView(){
//    tryNowButton.setOnClickListener {
//      navigateTo(OrderWithGroup::class.java)
//    }
//
//    toolbar.setOnClickListener {
//      finish()
//    }
  }
}
