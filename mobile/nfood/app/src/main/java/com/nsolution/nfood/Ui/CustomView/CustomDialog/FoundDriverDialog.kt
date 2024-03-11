package com.nsolution.nfood.Ui.CustomView.CustomDialog

import android.app.Activity
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.ResponseDriverDto
import com.nsolution.nfood.R

open class FoundDriverDialog(val activity: Activity) : BaseDialog(activity){
  
  private var driver : ResponseDriverDto? = null
  
  fun getDriver(worker : ResponseDriverDto){
    this.driver = worker
  }
  
  override fun createDialog() {
    super.createDialog()
    setContentView(R.layout.layout_found_driver)
    
    val driverAvatar = view?.findViewById<ImageView>(R.id.driverAvatar)
    val driverName = view?.findViewById<TextView>(R.id.driverName)
    val driverMotor = view?.findViewById<TextView>(R.id.driverMotor)
    val driverRated = view?.findViewById<com.willy.ratingbar.ScaleRatingBar>(R.id.driverRated)
  
    driverName?.text = driver?.driverName
    driverMotor?.text = driver?.driverMotor
    driverRated?.rating = driver?.driverRate!!.toFloat()
    Image(activity).apply {
      setErrorImage(R.drawable.illustration_avatar_default)
      setImage(driverAvatar!!,driver?.driverAvatar)
    }
  }
}