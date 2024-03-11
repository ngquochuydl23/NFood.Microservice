package com.nsolution.nfood.Ui.Homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.MyOrderAdapter
import com.nsolution.nfood.Models.ItemMyOrderDto

import com.nsolution.nfood.R


class PastOrderFragment : Fragment() {
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_past_order, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  
   // pastOrders.layoutManager = LinearLayoutManager(context)
    getUpcomingOrder()
  }
  
  private fun getUpcomingOrder(){
    val itemUpcomingOrder = ItemMyOrderDto().apply {
      orderId = "NF-23032030"
      orderStatus = "Order Completed"
      itemNumbers = 2
      price = 40000.0
      restaurantName = "Jet's Chicken (1144 S Wabash Ave)"
      orderTime = "Estimated arrival: 5:05 PM"
      restaurantId = 1
      orderStatusType = "COMPLETED"
      restaurantImage = "https://cdn.concreteplayground.com/content/uploads/2020/04/Family-Feast-KFC-supplied.jpg"
    }
  
    val itemUpcomingOrder1 = ItemMyOrderDto().apply {
      orderId = "NF-23032030"
      orderStatus = "Order Cancel"
      itemNumbers = 2
      price = 40000.0
      restaurantName = "Jet's Chicken (1144 S Wabash Ave)"
      orderTime = "Estimated arrival: 5:45 PM"
      restaurantId = 1
      orderStatusType = "CANCEL"
      restaurantImage = "https://cdn.concreteplayground.com/content/uploads/2020/04/Family-Feast-KFC-supplied.jpg"
    }
    //pastOrders.adapter = MyOrderAdapter(arrayListOf(itemUpcomingOrder,itemUpcomingOrder1,itemUpcomingOrder,itemUpcomingOrder1))
  }
}
