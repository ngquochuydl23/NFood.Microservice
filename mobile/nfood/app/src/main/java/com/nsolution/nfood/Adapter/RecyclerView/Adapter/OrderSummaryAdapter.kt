package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.OrderSummaryHolder
import com.nsolution.nfood.Models.ItemOrderSummaryDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Currency.FormatCurrency

class OrderSummaryAdapter(val listOrderSummary: ArrayList<ItemOrderSummaryDto>?) :
  BaseAdapter<OrderSummaryHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderSummaryHolder {
    val view = getView(parent,viewType, R.layout.item_summary_order_food)
    return OrderSummaryHolder(view)
  }
  
  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: OrderSummaryHolder, position: Int) {
    val itemOrderSummary = listOrderSummary?.get(position)
    
    holder.foodName.text = itemOrderSummary?.foodName
    holder.foodAttribute.text = itemOrderSummary?.foodAttributes
    holder.foodCost.text = FormatCurrency.FormatCurrencyVietNam(itemOrderSummary?.foodCost)
    holder.quanlity.text = "x" + itemOrderSummary?.quanlity
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listOrderSummary)
  }
  
}