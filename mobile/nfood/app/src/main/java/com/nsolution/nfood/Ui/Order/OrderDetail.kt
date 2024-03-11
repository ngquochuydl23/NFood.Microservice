package com.nsolution.nfood.Ui.Order

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.OrderFoodAdapter
import com.nsolution.nfood.Models.ItemOrderFoodDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.Rate.RateRestaurant


class OrderDetail : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order_detail)
    initialView()
    getDetailOrder()
  }
  
  private fun initialView() {
//    getBackActionBar(header, getString(R.string.order_detail))
//    listOrderFood.layoutManager = LinearLayoutManager(this)
//    rateButton.setOnClickListener {
//      navigateTo(RateRestaurant::class.java)
//    }
  }
  
  private fun getDetailOrder() {
    val itemFoodOrder = ItemOrderFoodDto().apply {
      id = 1
      foodId = 1
      foodName = "Classic Hamburger"
      foodImage = "https://cdn.shopify.com/s/files/1/0269/5967/5490/products/6.2.jpg"
      foodPrice = 34000.0
      foodAttributes = "No Egg\nSmall"
      quanlity = 2
    }
    
//    listOrderFood.adapter =
//      OrderFoodAdapter(arrayListOf(itemFoodOrder, itemFoodOrder, itemFoodOrder))
  }
}
