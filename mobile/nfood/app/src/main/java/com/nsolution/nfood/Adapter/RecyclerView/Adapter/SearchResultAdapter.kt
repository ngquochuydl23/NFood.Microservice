package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.SearchResultHolder
import com.nsolution.nfood.Models.ItemSearchResultDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Restaurant.Restaurant

class SearchResultAdapter(val listSearchResult: ArrayList<ItemSearchResultDto>?) :
  BaseAdapter<SearchResultHolder>() {
  
  companion object {
    private val RESTAURANT_ID = "RESTAURANT_ID"
  }
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultHolder {
    val view = getView(parent, viewType, R.layout.item_search_result)
    return SearchResultHolder(view)
  }
  
  override fun onBindViewHolder(holder: SearchResultHolder, position: Int) {
    
    val itemSearchResult = listSearchResult?.get(position)
    
    holder.apply {
      restaurantName.text = itemSearchResult?.restaurantName
      restaurantType.text = itemSearchResult?.restaurantType
      deliveryTimeAndDistance.text = itemSearchResult?.deliveryTimeAndDistance
    }
    
    holder.containerLayout.setOnClickListener {
      navigateToRestaurant(itemSearchResult?.RestaurantId)
    }
    
    setImage(holder.restaurantImage,itemSearchResult?.restaurantImage)
    
    if(itemSearchResult?.restaurantRate != null && itemSearchResult.restaurantRate != 0.0) {
      holder.iconRate.visibility = View.VISIBLE
      holder.restaurantRate.text = itemSearchResult.restaurantRate.toString()
    } else {
      holder.iconRate.visibility = View.GONE
      holder.restaurantRate.text = null
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listSearchResult)
  }
  
  private fun navigateToRestaurant(id : Int?){
    /*Send Id restaurant to Restaurant Activity */
    val intent = Intent(context,Restaurant::class.java)
    intent.putExtra(RESTAURANT_ID,id)
    
    /*Navigate to Restaurant Activity*/
    context.startActivity(intent)
  }
}