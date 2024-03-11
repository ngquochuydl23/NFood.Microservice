package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.RestaurantHoriHolder
import com.nsolution.nfood.Models.ItemRestaurantHoriDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Restaurant.Restaurant

class RestaurantHoriAdapter(val listRestaurant : ArrayList<ItemRestaurantHoriDto>?) : BaseAdapter<RestaurantHoriHolder>() {
  
  companion object {
    val RESTAURANT_ID = "RESTAURANT_ID"
  }
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHoriHolder {
    val view = getView(parent, viewType, R.layout.item_restaurant_hori)
    return RestaurantHoriHolder(view)
  }
  
  override fun onBindViewHolder(holder: RestaurantHoriHolder, position: Int) {
    val restaurant = listRestaurant?.get(position)
    
    holder.restaurantName.text = restaurant?.restaurantName
    setImage(holder.restaurantImage,restaurant?.restaurantImage)
  
    holder.containerLayout.setOnClickListener {
      navigateToRestaurant(restaurant?.restaurantId)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listRestaurant)
  }
  
  private fun navigateToRestaurant(id : Int?){
    val intent = Intent(context, Restaurant::class.java)
    intent.putExtra(RESTAURANT_ID,id)
    context.startActivity(intent)
  }
}