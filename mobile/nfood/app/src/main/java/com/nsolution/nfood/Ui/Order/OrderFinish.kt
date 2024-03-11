package com.nsolution.nfood.Ui.Order

import android.os.Bundle
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.Rate.RateRestaurant


class OrderFinish : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order_finish)
    initialView()
  }
  
  private fun initialView(){
//    getBackActionBarWithoutTitle(toolbar)
//    rateButton.setOnClickListener {
//      navigateTo(RateRestaurant::class.java)
//      finish()
//    }
  }
}
