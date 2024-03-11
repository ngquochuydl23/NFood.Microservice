package com.nsolution.nfood.Ui.Restaurant

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mapbox.mapboxsdk.maps.MapView
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.WorkTimeAdapter
import com.nsolution.nfood.Models.ItemWorkTimeDto
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseMapboxActivity



class RestaurantDetail : BaseMapboxActivity() {
  
  private var mapView: MapView? = null
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    getInstanceMapbox()
    setContentView(R.layout.activity_restaurant_detail)
    initialView(savedInstanceState)
    getDetailRestaurant()
  }
  
  private fun initialView(savedInstanceState: Bundle?) {
    //getBackActionBarWithoutTitle(toolbar)
    
    mapView = findViewById(R.id.mapView)
    mapView?.onCreate(savedInstanceState)
  
//    getMapView(mapView)
//    phoneRestaurant.setOnClickListener {
//      val intent = Intent(Intent.ACTION_CALL)
//      intent.setData(Uri.parse("tel:0868684961"))
//    }
//    listWorkTime.layoutManager = LinearLayoutManager(this)
  }
  
  
  private fun getDetailRestaurant() {
    val location = LocationDto().apply {
      latitude = 11.9528
      longitude = 108.4399
    }
    getMap(location)
    
    
    val workTime = ItemWorkTimeDto().apply {
      dayOfWeek = "MONDAY"
      workTime = "06:30 - 22:30"
    }
    
//    listWorkTime.adapter = WorkTimeAdapter(
//      arrayListOf(
//        workTime,
//        workTime,
//        workTime,
//        workTime,
//        workTime,
//        workTime,
//        workTime
//      )
//    )
  }
  
  private fun getMap(location: LocationDto?) {
    mapView?.getMapAsync { mapboxMap ->
      setupMapStyle(mapboxMap)
      moveCamera(location)
      addMarker(location)
    }
  }
 
}
