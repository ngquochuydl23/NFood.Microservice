package com.nsolution.nfood.Ui.Homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.NotificationAdapter
import com.nsolution.nfood.Models.ItemNotificationDto
import com.nsolution.nfood.R


class NotificationFragment : Fragment() {
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_notification, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
    getListNotification()
  }
  
  private fun initialView() {
    //listNotification.layoutManager = LinearLayoutManager(context)
  }
  
  private fun getListNotification() {
    val notification1 = ItemNotificationDto().apply {
      title = "Free NFood vouchers for new customers"
      subtitle = "Tap and get the big deals for your first booking"
      createdOn = "23/03/2020"
    }
    
//    listNotification.adapter = NotificationAdapter(
//      arrayListOf(notification1, notification1, notification1, notification1)
//    )
  }
}
