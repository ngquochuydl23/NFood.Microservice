package com.nsolution.nfood.Ui.Rate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class RateDriver : BaseActivity() {
  
  companion object {
    lateinit var activity: Activity
  }
  
  init {
    activity = this
  }
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_rate_driver)
    //getBackActionBar(header,getString(R.string.rate_driver))
    
    initialView()
    getDriverInformation()
  }
  
  private fun initialView(){
//    skipButton.setOnClickListener {
//      onSkip()
//    }
//    nextButton.setOnClickListener {
//      onNext()
//    }
  }
  
  private fun getDriverInformation(){
//    Image(this).setImage(driverAvatar,"https://scontent.fdad3-3.fna.fbcdn.net/v/t1.15752-9/93796022_549545402634956_8195067002591641600_n.png?_nc_cat=109&ccb=3&_nc_sid=ae9488&_nc_ohc=iZeh0EWNHWAAX8SX13A&_nc_ht=scontent.fdad3-3.fna&oh=c605705ace9e17effb78fc8f3c99f72f&oe=60518A88")
//    driverName.text = "Trịnh Thị Ngọc Vân"
  }
  
  private fun onNext(){
    rateDriver()
  }
  
  private fun onSkip(){
    navigateRateRestaurant()
  }
  
  private fun rateDriver(){
//    val rated = rate.rating
//    val review = enterReview.text.toString()
//    navigateRateRestaurant()
  }
  
  private fun navigateRateRestaurant(){
    val intent = Intent(this,RateFood::class.java)
    startActivity(intent)
  }
}
