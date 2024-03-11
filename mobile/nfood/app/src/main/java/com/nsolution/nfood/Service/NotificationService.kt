package com.nsolution.nfood.Service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.nsolution.nfood.R

class NotificationService : FirebaseMessagingService() {
  
  override fun onNewToken(token: String) {
    super.onNewToken(token)
  }
  
  override fun onMessageReceived(remoteMessage: RemoteMessage) {
    super.onMessageReceived(remoteMessage)
  
    val notificationManager =
      getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    val channelId = getString(R.string.project_id)
  
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      handleNotificationAndroidO(notificationManager, channelId)
    }
  
    val notification = NotificationCompat.Builder(this, channelId)
      .setAutoCancel(true)
      .setColor(ContextCompat.getColor(this, R.color.colorAccent))
      .setContentTitle(getString(R.string.app_name))
      .setContentText(remoteMessage.notification?.body)
      .setDefaults(Notification.DEFAULT_ALL)
      .setWhen(System.currentTimeMillis())
      .setPriority(NotificationCompat.PRIORITY_HIGH)
      .setSmallIcon(R.drawable.ic_launcher_foreground)
      .build()
  
    notificationManager.notify(1000, notification)
  }
  
  @RequiresApi(Build.VERSION_CODES.O)
  private fun handleNotificationAndroidO(
    notificationManager: NotificationManager,
    channelId: String
  ) {
    createNotificationChannel(notificationManager, channelId)
    notificationManager
      .getNotificationChannel(channelId)
      ?.canBypassDnd()
  }
  
  @RequiresApi(Build.VERSION_CODES.O)
  private fun createNotificationChannel(
    notificationManager: NotificationManager,
    channelId: String
  ) {
    val notificationChannel =
      NotificationChannel(channelId, getString(R.string.app_name), IMPORTANCE_HIGH)
    notificationManager.createNotificationChannel(notificationChannel)
  }
}