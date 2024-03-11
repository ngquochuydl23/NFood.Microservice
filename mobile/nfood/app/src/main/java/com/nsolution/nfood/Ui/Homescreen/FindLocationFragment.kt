package com.nsolution.nfood.Ui.Homescreen

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.LocationOfDeviceSharedPreferences
import com.nsolution.nfood.Singleton.LocationSingleton
import com.nsolution.nfood.Utils.AddressFromLocation
import java.text.DateFormat
import java.util.*

class FindLocationFragment : Fragment() {
  
  private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
  private val REQUEST_CHECK_SETTINGS = 0x1
  private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
  private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2
  private val KEY_REQUESTING_LOCATION_UPDATES = "requesting-location-updates"
  private val KEY_LOCATION = "location"
  private val KEY_LAST_UPDATED_TIME_STRING = "last-updated-time-string"
  
  private lateinit var mLocationCallback: LocationCallback
  private lateinit var mFusedLocationClient: FusedLocationProviderClient
  private lateinit var mSettingsClient: SettingsClient
  private lateinit var mLocationRequest: LocationRequest
  private lateinit var mLocationSettingsRequest: LocationSettingsRequest
  private lateinit var fragmentActivity: FragmentActivity
  private lateinit var listenerFragment: FindLocationListener
  private lateinit var addressFromLocation: AddressFromLocation
  private lateinit var locationOfDeviceSharedPreferences: LocationOfDeviceSharedPreferences
  
  private var mCurrentLocation: Location? = null
  private var mRequestingLocationUpdates: Boolean = false
  private var mLastUpdateTime: String? = null
  
  private var permissions = arrayOf(
    Manifest.permission.ACCESS_FINE_LOCATION
  )
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_find_location, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  
    //markerAnimate.setAnimation(R.raw.find_location)
    
    fragmentActivity = requireActivity()
    locationOfDeviceSharedPreferences = LocationOfDeviceSharedPreferences(context)
    addressFromLocation = AddressFromLocation(context)
    listenerFragment = context as FindLocationListener
    mRequestingLocationUpdates = true
    mLastUpdateTime = ""
    
    locationOfDeviceSharedPreferences.deleteData()
    
    updateValuesFromBundle(savedInstanceState)
    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(fragmentActivity)
    mSettingsClient = LocationServices.getSettingsClient(fragmentActivity)
    
    createLocationCallback()
    createLocationRequest()
    buildLocationSettingsRequest()
  }
  
  private fun updateValuesFromBundle(savedInstanceState: Bundle?) {
    if (savedInstanceState != null) {
      if (savedInstanceState.keySet().contains(KEY_REQUESTING_LOCATION_UPDATES))
        mRequestingLocationUpdates = savedInstanceState.getBoolean(KEY_REQUESTING_LOCATION_UPDATES)
      if (savedInstanceState.keySet().contains(KEY_LOCATION))
        mCurrentLocation = savedInstanceState.getParcelable(KEY_LOCATION)
      if (savedInstanceState.keySet().contains(KEY_LAST_UPDATED_TIME_STRING))
        mLastUpdateTime = savedInstanceState.getString(KEY_LAST_UPDATED_TIME_STRING)
      updateLocationUI()
    }
  }
  
  private fun createLocationRequest() {
    mLocationRequest = LocationRequest()
    mLocationRequest.interval = UPDATE_INTERVAL_IN_MILLISECONDS
    mLocationRequest.fastestInterval = FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
    mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
  }
  
  private fun createLocationCallback() {
//    mLocationCallback = object : LocationCallback() {
//      override fun onLocationResult(locationResult: LocationResult?) {
//        super.onLocationResult(locationResult)
//        mCurrentLocation = locationResult?.lastLocation
//        mLastUpdateTime = DateFormat.getTimeInstance().format(Date())
//        updateLocationUI()
//      }
//    }
  }
  
  private fun buildLocationSettingsRequest() {
    val builder = LocationSettingsRequest.Builder()
    builder.addLocationRequest(mLocationRequest)
    mLocationSettingsRequest = builder.build()
  }
  
  private fun updateLocationUI() {
    if (mCurrentLocation != null) {
      stopLocationUpdates()
      val shortAddress = addressFromLocation.getStreet(mCurrentLocation)
      val longAddress = addressFromLocation.getAddressDetail(mCurrentLocation)
      
      if (shortAddress != null ) {
        
        val location =
          LocationDto.convertLocationToLocationDto(mCurrentLocation, shortAddress, longAddress)
        
        locationOfDeviceSharedPreferences.setData(location)
        updateAddressTextView(shortAddress)
        updateLocationSingleton(location)
      }
      val handler = Handler()
      handler.postDelayed(delayInMinutes, 2000)
    }
  }
  
  private fun startLocationUpdates() {
    mSettingsClient.checkLocationSettings(mLocationSettingsRequest)
      .addOnSuccessListener(fragmentActivity, object : OnSuccessListener<LocationSettingsResponse> {
        override fun onSuccess(locationSettingsResponse: LocationSettingsResponse?) {
//          mFusedLocationClient
//            .requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper())
          updateLocationUI()
        }
      })
      .addOnFailureListener(fragmentActivity, object : OnFailureListener {
        override fun onFailure(exception: Exception) {
          val statusCode = (exception as ApiException).statusCode
          when (statusCode) {
            LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
              try {
                val resolveApi = exception as ResolvableApiException
                resolveApi.startResolutionForResult(fragmentActivity, REQUEST_CHECK_SETTINGS)
              } catch (sie: IntentSender.SendIntentException) {
                Log.i(TAG, "PendingIntent unable to execute request.")
              }
            }
            LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
              val errorMessage = "Location settings are inadequate, and cannot be " +
                      "fixed here. Fix in Settings."
              Log.e(TAG, errorMessage)
              Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
              mRequestingLocationUpdates = false
            }
          }
          updateLocationUI()
        }
      })
  }
  
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == REQUEST_CHECK_SETTINGS) {
      when (resultCode) {
        Activity.RESULT_OK ->
          Log.i(TAG, "User agreed to make required location settings changes.")
        Activity.RESULT_CANCELED -> {
          mRequestingLocationUpdates = false
          updateLocationUI()
        }
      }
    }
  }
  
  private fun stopLocationUpdates() {
    if (!mRequestingLocationUpdates) {
      Log.d(TAG, "stopLocationUpdates: updates never requested, no-op.")
    }
    mFusedLocationClient
      .removeLocationUpdates(mLocationCallback)
      .addOnCompleteListener(fragmentActivity, object : OnCompleteListener<Void> {
        override fun onComplete(task: Task<Void>) {
          mRequestingLocationUpdates = false
        }
      })
  }
  
  override fun onResume() {
//    markerAnimate.pauseAnimation()
//    markerAnimate.playAnimation()
    checkPermissions()
    super.onResume()
  }
  
  override fun onSaveInstanceState(savedInstanceState: Bundle) {
    savedInstanceState.putBoolean(KEY_REQUESTING_LOCATION_UPDATES, mRequestingLocationUpdates)
    savedInstanceState.putParcelable(KEY_LOCATION, mCurrentLocation)
    savedInstanceState.putString(KEY_LAST_UPDATED_TIME_STRING, mLastUpdateTime)
    super.onSaveInstanceState(savedInstanceState)
  }
  
  private fun checkPermissions() {
    val permissionState =
      ActivityCompat.checkSelfPermission(fragmentActivity, Manifest.permission.ACCESS_FINE_LOCATION)
    if (mRequestingLocationUpdates && permissionState == PackageManager.PERMISSION_GRANTED) {
      startLocationUpdates()
    } else ActivityCompat.requestPermissions(
      fragmentActivity,
      permissions,
      REQUEST_PERMISSIONS_REQUEST_CODE
    )
  }
  
  private val delayInMinutes = Runnable {
    //markerAnimate.pauseAnimation()
    fragmentManager?.beginTransaction()?.remove(this)?.commit()
    listenerFragment.onRemoveFragment()
  }
  
  private fun updateLocationSingleton(location: LocationDto) {
    LocationSingleton.instance.updateData(location)
  }
  
  private fun updateAddressTextView(address: String?) {
    //currentAddress.setText(address)
  }
  
  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE && grantResults.isNotEmpty()) {
      startLocationUpdates()
    }
  }
  
  interface FindLocationListener {
    fun onRemoveFragment()
  }
  
  override fun onStop() {
    stopLocationUpdates()
    //markerAnimate.pauseAnimation()
    super.onStop()
  }
}
