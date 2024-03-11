package com.nsolution.nfood.Ui.SelectLocation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.SeachGeoAdapter
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.Models.RequestGeoCodingDto
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IGeo
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.LocationOfDeviceSharedPreferences
import com.nsolution.nfood.Singleton.LocationSingleton
import com.nsolution.nfood.Ui.Base.BaseActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class SelectLocation : BaseActivity(), HttpClient {
  
  lateinit var service: IGeo
  lateinit var searchGeoAdapter: SeachGeoAdapter
  private var currentLocationOfDevice: LocationDto? = null
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_location)
    service = goongRetrofit.create(IGeo::class.java)
    
    initialView()
    
    currentLocationOfDevice = LocationOfDeviceSharedPreferences(this).getData()
    updateLocationUi(currentLocationOfDevice)
  }
  
  private fun getGooingApiKey(): String? {
    return getString(R.string.goong_api_key)
  }
  
  private fun initialView() {
//    getBackActionBar(header, getString(R.string.select_location))
//
//    listSearchGeo.layoutManager = LinearLayoutManager(this)
//    selectLocationOnMap.setOnClickListener {
//      navigateTo(SelectLocationOnMap::class.java)
//    }
//
//    selectCurrentLocation.setOnClickListener {
//      selectCurrentLocation(currentLocationOfDevice)
//    }
//
//    searchInput.addTextChangedListener(object : TextWatcher {
//      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//
//      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//
//      override fun afterTextChanged(s: Editable?) {
//        if (searchInput.text.isNotEmpty()) {
//          searchGeo(searchInput.text.toString())
//        } else {
//          showLayoutCurrentLocation()
//          listSearchGeo.adapter = null
//        }
//      }
//    })
  }
  
  private fun selectCurrentLocation(location: LocationDto?) {
    updateLocationSingleton(location)
    finish()
  }
  
  private fun updateLocationUi(location: LocationDto?) {
//    if (location != null && location.address?.isNotEmpty()!!) {
//      currentLocation.text = location.address
//    } else currentLocation.text = getString(R.string.location_could_not_be_found)
  }
  
  private fun searchGeo(address: String?) {
    hideLayoutCurrentLocation()
    
    val goongApiKey = getGooingApiKey()
    val requestGeoCoding = RequestGeoCodingDto(address)
    
    service.searchGeoCoding(goongApiKey, requestGeoCoding)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        val result = it.results
  
        searchGeoAdapter = object : SeachGeoAdapter(result) {
          override fun selectItemGeo(location: LocationDto?) {
            updateLocationSingleton(location)
            finish()
          }
        }
        //listSearchGeo.adapter = searchGeoAdapter
      }, {
        it.printStackTrace()
      })
  }
  
  private fun showLayoutCurrentLocation() {
    //selectCurrentLocation.visibility = View.VISIBLE
  }
  
  private fun hideLayoutCurrentLocation() {
    //selectCurrentLocation.visibility = View.GONE
  }
  
  private fun updateLocationSingleton(location: LocationDto?) {
    LocationSingleton.instance.updateData(location)
  }
}
