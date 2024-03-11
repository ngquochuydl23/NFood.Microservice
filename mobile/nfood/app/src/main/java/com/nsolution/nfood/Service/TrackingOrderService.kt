package com.nsolution.nfood.Service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.nsolution.nfood.Hub.TrackingOrderHub

class TrackingOrderService : Service() {
  
  private var trackingOrderHub : TrackingOrderHub? = null
  
  override fun onCreate() {
    super.onCreate()
    trackingOrderHub = TrackingOrderHub(this)
  }
  
  override fun onBind(intent: Intent?): IBinder? {
    TODO("Not yet implemented")
  }
  
  
}