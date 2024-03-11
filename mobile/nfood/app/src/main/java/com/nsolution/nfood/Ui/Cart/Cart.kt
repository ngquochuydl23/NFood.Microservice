package com.nsolution.nfood.Ui.Cart


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.CartAdapter
import com.nsolution.nfood.Models.ItemCartDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Singleton.LocationSingleton
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.CustomView.CustomBottomSheet.HelpDriverBottomSheet
import com.nsolution.nfood.Ui.Order.TrackingOrder


class Cart : BaseActivity() {
  
  lateinit var helpDriverBottomSheet: HelpDriverBottomSheet
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cart)
    initialView()
    initialData()
    
//    LocationSingleton.instance.data.observe(this, Observer {
//      address.text = it.address
//    })
  }
  
  private fun initialView() {
//    getBackActionBar(header, getString(R.string.cart))
//
//    orderSummarys.layoutManager = LinearLayoutManager(this)
//    helpDriverBottomSheet = HelpDriverBottomSheet()
//    progressBar.visibility = View.GONE
//
//    orderButton.setOnClickListener {
//      orderAction()
//    }
    
  }
  
  private fun initialData() {
    getListProduct()
  }
  
  private fun getListProduct() {
    val cart = ItemCartDto().apply {
      id = 1
      foodId = 1
      foodName = "Classic Hamburger"
      foodImage = "https://cdn.shopify.com/s/files/1/0269/5967/5490/products/6.2.jpg"
      cost = 39000.0
      foodAttributes = "No Egg\nSmall"
      quanlity = 2
    }
   // orderSummarys.adapter = CartAdapter(arrayListOf(cart, cart))
    
  }
  
  private fun orderAction() {
    navigateTo(TrackingOrder::class.java)
    finish()
  }
  
  private fun selectPayment() {
  
  }
  
  private fun selectVoucher() {
    
  }
}
