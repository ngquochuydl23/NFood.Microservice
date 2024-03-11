package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Holder.OrderWithGroupHolder
import com.nsolution.nfood.Models.ItemOrderGroupDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Currency.FormatCurrency

class OrderWithGroupAdapter(val listOrderGroup: ArrayList<ItemOrderGroupDto>?) :
  BaseAdapter<OrderWithGroupHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderWithGroupHolder {
    val view = getView(parent, viewType, R.layout.item_order_group)
    return OrderWithGroupHolder(view)
  }
  
  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: OrderWithGroupHolder, position: Int) {
    val itemOrderGroup = listOrderGroup?.get(position)
    
    if (itemOrderGroup?.isMe!!) {
      holder.userName.text = itemOrderGroup.userName + " (You)"
    } else {
      holder.userName.text = itemOrderGroup.userName
    }
    
    setImage(holder.userAvatar, itemOrderGroup.userAvatar)
    
    holder.orderSummarys.layoutManager = LinearLayoutManager(context)
    holder.orderSummarys.adapter = OrderSummaryAdapter(itemOrderGroup.listSummaryFood)
    holder.numberItems.text = "${itemOrderGroup.listSummaryFood?.size} Item"
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listOrderGroup)
  }
}