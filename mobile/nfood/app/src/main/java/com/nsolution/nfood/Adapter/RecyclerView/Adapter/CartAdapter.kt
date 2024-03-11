package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.CartHolder
import com.nsolution.nfood.Models.ItemCartDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Currency.FormatCurrency
import com.nsolution.nfood.Ui.Food.FoodDetail

open class CartAdapter(val listCart : ArrayList<ItemCartDto>?) : BaseAdapter<CartHolder>() {
  
  private val FOOD_ID = "FOOD_ID"
  private val CART_ID = "CART_ID"
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
    val view = getView(parent,viewType, R.layout.item_cart)
    return CartHolder(view)
  }
  
  override fun onBindViewHolder(holder: CartHolder, position: Int) {
    val item = listCart?.get(position)
    
    holder.foodName.text = item?.foodName
    holder.foodAttributes.text = item?.foodAttributes
    holder.foodQuanlity.text = item?.quanlity.toString()
    holder.foodCost.text = FormatCurrency.FormatCurrencyVietNam(item?.cost)
    
    setImage(holder.foodImage,item?.foodImage)
    
    holder.increaseClick.setOnClickListener {
      increaseClick()
    }
    
    holder.decreaseClick.setOnClickListener {
      decreaseClick()
    }
    
    holder.containerLayout.setOnClickListener {
      navigateToDetailFood(item?.foodId,item?.id)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listCart)
  }
  
  open fun decreaseClick(){ }
  
  open fun increaseClick(){ }
  
  private fun navigateToDetailFood(id : Int?,idCart : Int?){
    val intent = Intent(context, FoodDetail::class.java)
    intent.putExtra(FOOD_ID,id)
    intent.putExtra(CART_ID,idCart)
    context.startActivity(intent)
  }
}