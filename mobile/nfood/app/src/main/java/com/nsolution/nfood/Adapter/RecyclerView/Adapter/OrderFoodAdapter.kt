package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.OrderFoodHolder
import com.nsolution.nfood.Models.ItemOrderFoodDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Currency.FormatCurrency

class OrderFoodAdapter(val listOrderFood: ArrayList<ItemOrderFoodDto>?) :
  BaseAdapter<OrderFoodHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderFoodHolder {
    val view = getView(parent,viewType, R.layout.item_order_food)
    return OrderFoodHolder(view)
  }
  
  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: OrderFoodHolder, position: Int) {
    val itemFoodOrder = listOrderFood?.get(position)
    
    setImage(holder.foodImage,itemFoodOrder?.foodImage)
    holder.foodName.text = itemFoodOrder?.foodName
    holder.foodAttributes.text = itemFoodOrder?.foodAttributes
    holder.foodPrice.text = FormatCurrency.FormatCurrencyVietNam(itemFoodOrder?.foodPrice)
    holder.foodQuanlity.text = "x" + itemFoodOrder?.quanlity.toString()
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listOrderFood)
  }
  
}