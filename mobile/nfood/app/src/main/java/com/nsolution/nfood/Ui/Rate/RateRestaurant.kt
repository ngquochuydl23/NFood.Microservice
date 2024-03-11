package com.nsolution.nfood.Ui.Rate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class RateRestaurant : BaseActivity() {
  
  companion object {
    lateinit var activity: Activity
  }
  
  init {
    activity = this
  }
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_rate_restaurant)
    //getBackActionBar(header,getString(R.string.rate_restaurant))
    
    initialView()
    getRestaurantInformation()
  }
  
  private fun initialView(){
//    skipButton.setOnClickListener {
//      onSkip()
//    }
//    nextButton.setOnClickListener {
//      onNext()
//    }
  }
  
  private fun getRestaurantInformation(){
    //Image(this).setImage(restaurantImage, "https://d1ralsognjng37.cloudfront.net/a7002177-10a0-4cee-98e3-007e5805fc7e.jpeg")
    //restaurantName.text = "KFC Camberwell - Church Street"
  }
  
  private fun onNext(){
    rateRestaurant()
  }
  
  private fun onSkip(){
    navigateToRateFood()
  }
  
  private fun rateRestaurant(){
    //val rated = rate.rating
    //val review = enterReview.text.toString()
    //navigateToRateFood()
  }
  
  private fun navigateToRateFood(){
    val intent = Intent(this,RateDriver::class.java)
    startActivity(intent)
  }
}
