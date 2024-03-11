package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.NotificationHolder
import com.nsolution.nfood.Models.ItemNotificationDto
import com.nsolution.nfood.R

class NotificationAdapter(val listNotification: ArrayList<ItemNotificationDto>?) :
  BaseAdapter<NotificationHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationHolder {
    val view = getView(parent, viewType, R.layout.item_notification)
    return NotificationHolder(view)
  }
  
  override fun onBindViewHolder(holder: NotificationHolder, position: Int) {
    val itemNotification = listNotification?.get(position)
    val notificationId = itemNotification?.id
  
    holder.apply {
      title.text = itemNotification?.title
      subtitle.text = itemNotification?.subtitle
      createdOn.text = itemNotification?.createdOn
    }
    
    holder.containerLayout.setOnClickListener {
      navigateToNotificationDetail(notificationId)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listNotification)
  }
  
  private fun navigateToNotificationDetail(id : Int?){

  }
}