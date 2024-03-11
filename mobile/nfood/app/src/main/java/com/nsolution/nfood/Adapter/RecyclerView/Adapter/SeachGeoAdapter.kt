package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.google.gson.Gson
import com.nsolution.nfood.Adapter.RecyclerView.Holder.SearchGeoHolder
import com.nsolution.nfood.Models.ItemGeoCodingDto
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.Models.LocationGeoCodingDto
import com.nsolution.nfood.R

open class SeachGeoAdapter(val listGeo : ArrayList<ItemGeoCodingDto>?) : BaseAdapter<SearchGeoHolder>(){
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchGeoHolder {
    val view = getView(parent,viewType, R.layout.item_search_geo)
    return SearchGeoHolder(view)
  }
  
  override fun onBindViewHolder(holder: SearchGeoHolder, position: Int) {

    val item = listGeo?.get(position)
    val geometry = item?.geometry?.location
    val shortName = item?.addressComponents?.get(0)?.short_name
    val formattedAddress = item?.formattedAddress
    
    holder.shortName.text = shortName
    holder.formattedAddress.text = formattedAddress

    holder.containerLayout.setOnClickListener {
      
      val location = LocationDto()
      
      location.latitude = geometry?.lat
      location.longitude = geometry?.lng
      location.address = shortName
      location.detailAddress = formattedAddress
      
      selectItemGeo(location)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listGeo)
  }
  
  open fun selectItemGeo(geometry : LocationDto?){
  
  }
}