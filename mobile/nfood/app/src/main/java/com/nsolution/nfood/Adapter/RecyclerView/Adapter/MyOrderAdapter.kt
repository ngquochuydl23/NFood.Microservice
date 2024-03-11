package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.nsolution.nfood.Adapter.RecyclerView.Holder.MyOrderHolder
import com.nsolution.nfood.Models.ItemMyOrderDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Currency.FormatCurrency
import com.nsolution.nfood.Ui.Order.OrderDetail
import com.nsolution.nfood.Ui.Restaurant.Restaurant

class MyOrderAdapter(val listMyOrder: ArrayList<ItemMyOrderDto>?) : BaseAdapter<MyOrderHolder>() {
  
  private val UPCOMING = "UPCOMING"
  private val COMPLETED = "COMPLETED"
  private val CANCEL = "CANCEL"
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderHolder {
    val view = getView(parent, viewType, R.layout.item_my_order)
    return MyOrderHolder(view)
  }
  
  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: MyOrderHolder, position: Int) {
    val itemMyOrder = listMyOrder?.get(position)
    
    setImage(holder.restaurantImage, itemMyOrder?.restaurantImage)
    
    holder.orderId.text = "Order : ${itemMyOrder?.orderId}"
    holder.restaurantName.text = itemMyOrder?.restaurantName
    holder.numberItemAndPrice.text =
      "${itemMyOrder?.itemNumbers} items - ${FormatCurrency.FormatCurrencyVietNam(itemMyOrder?.price)}"
    holder.orderStatus.text = itemMyOrder?.orderStatus
    holder.orderTime.text = itemMyOrder?.orderTime
    
    
    holder.orderAgainButton.setOnClickListener {
      navigateToRestaurant(itemMyOrder?.restaurantId)
    }
    
    holder.cancelOrderButton.setOnClickListener {
    
    }
    
    holder.containerLayout.setOnClickListener {
      navigateToOrderDetail(itemMyOrder?.orderId)
    }
    
    
    if (itemMyOrder?.orderStatusType == UPCOMING) {
      setColorTextView(holder.orderStatus, R.color.black)
    } else if (itemMyOrder?.orderStatusType == COMPLETED) {
      setColorTextView(holder.orderStatus, R.color.green)
    } else if (itemMyOrder?.orderStatusType == CANCEL) {
      setColorTextView(holder.orderStatus, R.color.red)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listMyOrder)
  }
  
  private fun navigateToRestaurant(restaurantId: Int?) {
    val intent = Intent(context, Restaurant::class.java)
    context.startActivity(intent)
  }
  
  private fun navigateToOrderDetail(orderId: String?) {
    val intent = Intent(context, OrderDetail::class.java)
    context.startActivity(intent)
  }
  
  private fun setColorTextView(textView: TextView, color: Int) {
    textView.setTextColor(ContextCompat.getColor(context, color))
  }
}