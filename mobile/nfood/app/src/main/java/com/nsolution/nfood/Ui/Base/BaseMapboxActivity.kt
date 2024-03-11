package com.nsolution.nfood.Ui.Base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.content.ContextCompat
import com.mapbox.api.directions.v5.DirectionsCriteria
import com.mapbox.api.directions.v5.MapboxDirections
import com.mapbox.api.directions.v5.models.DirectionsResponse
import com.mapbox.api.directions.v5.models.DirectionsRoute
import com.mapbox.core.constants.Constants.PRECISION_6
import com.mapbox.geojson.Feature
import com.mapbox.geojson.LineString
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.annotations.PolylineOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.maps.UiSettings
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.CustomView.CustomMarker.Marker
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseMapboxActivity : BaseActivity() {
  
  private var mapView: MapView? = null
  var mapboxMap: MapboxMap? = null
  private var currentRoute: DirectionsRoute? = null
  private var client: MapboxDirections? = null
  
  fun getInstanceMapbox() {
    val accessToken = getAccessTokenMapbox()
    Mapbox.getInstance(this, accessToken)
  }
  
  fun getAccessTokenMapbox(): String {
    return getString(R.string.mapbox_access_token)
  }
  
  fun getMapView(mapView: MapView?) {
    this.mapView = mapView
  }
  
  fun setupMapStyle(mapboxMap: MapboxMap) {
    this.mapboxMap = mapboxMap
    mapboxMap.setStyle(Style.MAPBOX_STREETS) {
      val uiSettings: UiSettings = mapboxMap.uiSettings
      uiSettings.isCompassEnabled = false
      uiSettings.isLogoEnabled = false
      uiSettings.isAttributionEnabled = false
    }
  }
  
  fun moveCamera(location: LocationDto?) {
    if (location != null) {
      val latLng = LatLng(location.latitude!!, location.longitude!!)
      val position = CameraPosition
        .Builder()
        .target(latLng)
        .zoom(15.0)
        .build()
      
      
      mapboxMap?.animateCamera(CameraUpdateFactory.newCameraPosition(position), 1)
    }
  }
  
  fun addMarker(location: LocationDto?) {
    if (location != null) {
      val latLng = LatLng(location.latitude!!, location.longitude!!)
      val markerBitmap = Marker(this).getIconMarker(R.drawable.icon_marker_home)
      val iconFactory = IconFactory.getInstance(this)
      val icon = iconFactory.fromBitmap(markerBitmap)
      val markerOption = MarkerOptions().position(latLng).icon(icon)
      mapboxMap?.addMarker(markerOption)
    }
  }
  
  fun mapDirectionsRequest(origin: LatLng, destination: LatLng) {
    
    val startPoint = Point.fromLngLat(destination.longitude, destination.latitude)
    val endPoint = Point.fromLngLat(origin.longitude, origin.latitude)
    
    client = MapboxDirections.builder()
      .origin(startPoint)
      .destination(endPoint)
      .overview(DirectionsCriteria.OVERVIEW_FULL)
      .profile(DirectionsCriteria.PROFILE_DRIVING)
      .accessToken(getAccessTokenMapbox())
      .build()
    
    client?.enqueueCall(object : Callback<DirectionsResponse> {
      override fun onResponse(
        call: Call<DirectionsResponse>,
        response: Response<DirectionsResponse>
      ) {
        val responseBody = response.body()
        val routes = responseBody?.routes()
    
        if (response.isSuccessful && responseBody != null && routes?.isNotEmpty()!!) {
          currentRoute = routes.first()
          if (currentRoute != null) {
            val latLngBounds = LatLngBounds.Builder()
              .include(origin)
              .include(destination)
              .build()
            
            val cameraUpdateFactory = CameraUpdateFactory.newLatLngBounds(latLngBounds, 20)
        
            mapboxMap?.animateCamera(cameraUpdateFactory)
            mapboxMap?.setPadding(10,10,10,10)
            drawNavigationPolylineRoute(currentRoute!!)
          }
        }
      }
  
      override fun onFailure(call: Call<DirectionsResponse>, throwable: Throwable) {
        throwable.printStackTrace()
      }
    })
  }
  
  fun drawNavigationPolylineRoute(route: DirectionsRoute) {
    mapboxMap?.getStyle { style ->
      
      val listPoint = arrayListOf<LatLng>()
      val directionsRouteFeatureList: ArrayList<Feature> = ArrayList()
      val lineString: LineString = LineString.fromPolyline(route.geometry()!!, PRECISION_6)
      val coordinates: List<Point> = lineString.coordinates()
      
      for (point in coordinates) {
        directionsRouteFeatureList.add(Feature.fromGeometry(LineString.fromLngLats(coordinates)))
        listPoint.add(LatLng(point.latitude(), point.longitude()))
      }
      
      val polyline = mapboxMap?.polylines
      val polylineOptions = setUpPolylineOption(listPoint)
      
      if (mapboxMap?.polylines.isNullOrEmpty() && polyline?.size!! > 0) {
        mapboxMap?.removePolyline(polyline.get(0))
      }
      mapboxMap?.addPolyline(polylineOptions)
    }
    
  }
  
  fun setUpPolylineOption(listPoint: ArrayList<LatLng>): PolylineOptions {
    return PolylineOptions()
      .addAll(listPoint)
      .color(ContextCompat.getColor(this, R.color.green))
      .width(5f)
  }
  
  
  fun getDirection(origin: LocationDto?, destination: LocationDto?) {
    if(origin != null && destination != null) {
      val latLngOrigin = LatLng().apply {
        latitude = origin.latitude!!
        longitude = origin.longitude!!
      }
  
      val latLngDestination = LatLng().apply {
        latitude = destination.latitude!!
        longitude = destination.longitude!!
      }
      mapDirectionsRequest(latLngOrigin, latLngDestination)
    }
    
    
    
  }
  
  override fun onResume() {
    super.onResume()
    mapView?.onResume()
  }
  
  override fun onStart() {
    super.onStart()
    mapView?.onStart()
  }
  
  override fun onStop() {
    super.onStop()
    mapView?.onStop()
  }
  
  public override fun onPause() {
    super.onPause()
    mapView?.onPause()
  }
  
  override fun onLowMemory() {
    super.onLowMemory()
    mapView?.onLowMemory()
  }
  
  override fun onDestroy() {
    super.onDestroy()
    mapView?.onDestroy()
  }
  
  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    mapView?.onSaveInstanceState(outState)
  }
}