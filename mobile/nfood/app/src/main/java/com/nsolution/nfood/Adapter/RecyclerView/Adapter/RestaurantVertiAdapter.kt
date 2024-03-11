package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.RestaurantVertiHolder
import com.nsolution.nfood.Models.ItemRestaurantVertiDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Restaurant.Restaurant

class RestaurantVertiAdapter(val listRestaurant : ArrayList<ItemRestaurantVertiDto>?,val isLarge : Boolean) : BaseAdapter<RestaurantVertiHolder>() {
  
  private val RESTAURANT_ID = "RESTAURANT_ID"
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantVertiHolder {
    val largeView = getView(parent, viewType, R.layout.item_restaurant_large_vertical)
    val smallView = getView(parent, viewType, R.layout.item_restaurant_small_vertical)
    if(isLarge)
      return RestaurantVertiHolder(largeView)
    return RestaurantVertiHolder(smallView)
  }
  
  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: RestaurantVertiHolder, position: Int) {
    val restaurant = listRestaurant?.get(position)
    
    holder.restaurantName.text = restaurant?.restaurantName
    setImage(holder.restaurantImage,restaurant?.restaurantImage)
    
    holder.restaurantType.text = restaurant?.restaurantType
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