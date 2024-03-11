package com.nsolution.nfood.Ui.Rate

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.RateFoodAdapter
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.ItemRateFoodDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity

class RateFood : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_rate_food)


//    getActionBar(header,getString(R.string.rate_food))
//    initialView()
//    getListRate()
//    restaurantName.text = "KFC Camberwell - Church Street"
//    Image(this).setImage(restaurantImage,"https://d1ralsognjng37.cloudfront.net/a7002177-10a0-4cee-98e3-007e5805fc7e.jpeg")
//
  }
  
  private fun initialView() {
//    listFoodRate.layoutManager = LinearLayoutManager(this)
//
//    nextButton.setOnClickListener {
//      RateRestaurant.activity.finish()
//      RateDriver.activity.finish()
//      finish()
//    }
  }
  
  private fun getListRate() {
    val rate1 = ItemRateFoodDto().apply {
      foodImage = "https://mcdonalds.com.pk/wp-content/uploads/01-Mega-Mac-600x600.png"
      foodName = "Double Big Mac Meal"
      isLike = 0
    }
//    listFoodRate.adapter = RateFoodAdapter(
//      arrayListOf(
//        rate1, rate1, rate1, rate1
//      )
//    )
  }
  
}
