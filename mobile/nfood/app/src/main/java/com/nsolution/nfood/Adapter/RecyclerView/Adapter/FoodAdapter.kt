package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.FoodHolder
import com.nsolution.nfood.Models.ItemFoodDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Currency.FormatCurrency
import com.nsolution.nfood.Ui.Food.FoodDetail
import com.nsolution.nfood.Ui.Restaurant.Restaurant

class FoodAdapter(val listFood : ArrayList<ItemFoodDto>?) : BaseAdapter<FoodHolder>(){
  
  companion object {
    val RESTAURANT_ID = "RESTAURANT_ID"
    val FOOD_ID = "FOOD_ID"
  }
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
    val view = getView(parent,viewType, R.layout.item_food)
    return FoodHolder(view)
  }
  
  override fun onBindViewHolder(holder: FoodHolder, position: Int) {
    val food = listFood?.get(position)
    holder.foodName.text = food?.foodName
    holder.restaurantName.text = food?.restaurantName
    
    setImage(holder.foodImage,food?.foodImage)
    
    holder.foodCost.text = FormatCurrency.FormatCurrencyVietNam(food?.foodCost)
    
    holder.containerLayout.setOnClickListener {
      navigateToRestaurant(food?.foodId)
      navigateToFoodDetail(food?.restaurantId)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listFood)
  }
  
  private fun navigateToRestaurant(id : Int?){
    val intent = Intent(context, Restaurant::class.java)
    intent.putExtra(RESTAURANT_ID,id)
    context.startActivity(intent)
  }
  
  private fun navigateToFoodDetail(id : Int?){
    val intent = Intent(context, FoodDetail::class.java)
    intent.putExtra(FOOD_ID,id)
    context.startActivity(intent)
  }
}