package com.nsolution.nfood.Ui.Order

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.mapbox.mapboxsdk.maps.MapView
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.Models.ResponseDriverDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Singleton.LocationSingleton
import com.nsolution.nfood.Ui.Base.BaseMapboxActivity
import com.nsolution.nfood.Animation.ProgressBarAnimation
import com.nsolution.nfood.Ui.CustomView.CustomDialog.FoundDriverDialog


class TrackingOrder : BaseMapboxActivity() {
  
  private var mapView: MapView? = null
  lateinit var foundDriverDialog: FoundDriverDialog
  
  
  private var handler = Handler()
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    getInstanceMapbox()
    setContentView(R.layout.activity_tracking_order)
    initialView(savedInstanceState)
    onCookingStep()
  }
  
  private fun initialView(savedInstanceState: Bundle?) {
//    getBackActionBarWithoutTitle(toolbar)
//    hideView(mapLayout)
//    hideView(driverContractLayout)
    
    foundDriverDialog = FoundDriverDialog(this)
    mapView = findViewById(R.id.mapView)
    mapView?.onCreate(savedInstanceState)
  
    getMapView(mapView)
  }
  
  private fun getMap(location : LocationDto?){
    mapView?.getMapAsync { mapboxMap ->
      setupMapStyle(mapboxMap)
      moveCamera(location)
    }
  }
  
  private fun setupStepAnimatedView() {
//    orderStepAnimated.apply {
//      playAnimation()
//      setAnimation(R.raw.cooking_step)
//    }
  }
  
  private fun onCookingStep() {
   // showView(orderStepAnimated)
    setupStepAnimatedView()
    delayThreeSecond({ onFoundDriver() })
  }
  
  private fun onFoundDriver(){
    updateProgressOrder(20, 40)
   // showView(driverContractLayout)
    val driver = ResponseDriverDto().apply {
      driverId = 1
      driverName = "Trịnh Thị Ngọc Vân"
      driverMotor = "Honda Wave Rs - 49P1-1568"
      driverRate = 4.5
      driverAvatar = "https://scontent.fdad3-3.fna.fbcdn.net/v/t1.15752-9/93796022_549545402634956_8195067002591641600_n.png?_nc_cat=109&ccb=3&_nc_sid=ae9488&_nc_ohc=iZeh0EWNHWAAX8SX13A&_nc_ht=scontent.fdad3-3.fna&oh=c605705ace9e17effb78fc8f3c99f72f&oe=60518A88"
    }
    updateContractDriverUI(driver)
    showDriverInformation(driver)
    delayThreeSecond({ onDriverIsComing() })
  }
  
  private fun onDriverIsComing(){
    updateProgressOrder(40, 60)
    //hideView(orderStepAnimated)
    //showView(mapLayout)
    val location = LocationDto().apply {
      latitude = 11.9528
      longitude = 108.4399
    }
    getMap(location)
    
    val UserLocation = LocationSingleton.instance.data.value
    getDirection(UserLocation,location)
  
    //delayThreeSecond({ onFinishDelivery() })
  }
  
  private fun onFinishDelivery(){
    navigateTo(OrderFinish::class.java)
    finish()
  }
  
  private fun updateProgressOrder(currentValue: Int, updateValue: Int) {
    //val animation = ProgressBarAnimation(progressBar, currentValue, updateValue)
    //animation.duration = 1000
    //progressBar.startAnimation(animation)
  }
  
  private fun delayThreeSecond(function: () -> Unit) {
    handler.postDelayed({ function() }, 5000)
  }
  
  private fun showDriverInformation(driver: ResponseDriverDto) {
    foundDriverDialog.apply {
      getDriver(driver)
      createDialog()
      showDialog()
    }
  }
  
  private fun hideView(view: View) {
    view.visibility = View.GONE
  }
  
  private fun showView(view: View) {
    view.visibility = View.VISIBLE
  }
  
  private fun updateContractDriverUI(driver : ResponseDriverDto){
    //Image(applicationContext).setImage(driverAvatar,driver.driverAvatar)
    //driverName.text = driver.driverName
    //driverMotor.text = driver.driverMotor
  }
  
  override fun onStop() {
    super.onStop()
    Image(applicationContext).stopRequest()
  }
}
