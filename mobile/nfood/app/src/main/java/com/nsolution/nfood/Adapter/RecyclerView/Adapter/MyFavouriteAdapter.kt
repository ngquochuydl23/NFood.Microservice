package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Holder.MyFavouriteHolder
import com.nsolution.nfood.Models.ItemMyFavouriteDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Restaurant.Restaurant

class MyFavouriteAdapter(val listMyFavourite : ArrayList<ItemMyFavouriteDto>?) : BaseAdapter<MyFavouriteHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFavouriteHolder {
    val view = getView(parent,viewType, R.layout.item_my_favourite)
    return MyFavouriteHolder(view)
  }
  
  override fun onBindViewHolder(holder: MyFavouriteHolder, position: Int) {
    val itemMyFavourite = listMyFavourite?.get(position)
    
    holder.restaurantName.text = itemMyFavourite?.restaurantName
    holder.restaurantAddress.text = itemMyFavourite?.restaurantAddress
    holder.restaurantWorkTime.text = itemMyFavourite?.restaurantWorkTime
    
    setImage(holder.restaurantImage,itemMyFavourite?.restaurantImage)
    
    holder.listFavouriteFood.layoutManager = LinearLayoutManager(context)
    holder.listFavouriteFood.adapter = MenuChildAdapter(itemMyFavourite?.listFavouriteFood)
    
    holder.containerLayout.setOnClickListener {
      navigateToRestaurantActivity()
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listMyFavourite)
  }
  
  private fun navigateToRestaurantActivity(){
    val intent = Intent(context,Restaurant::class.java)
    context.startActivity(intent)
  }
  
}