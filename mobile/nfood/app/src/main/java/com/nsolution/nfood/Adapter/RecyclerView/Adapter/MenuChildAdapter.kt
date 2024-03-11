package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Holder.MenuChildHolder
import com.nsolution.nfood.Adapter.RecyclerView.Holder.MenuParentHolder
import com.nsolution.nfood.Models.ItemMenuChildDto
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IFood
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SaveToken
import com.nsolution.nfood.Ui.Currency.FormatCurrency
import com.nsolution.nfood.Ui.Food.FoodDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MenuChildAdapter(val list : ArrayList<ItemMenuChildDto>?) : BaseAdapter<MenuChildHolder>(),HttpClient {
  
  private val FOOD_ID = "FOOD_ID"
  lateinit var service: IFood
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuChildHolder {
    service = retrofit.create(IFood::class.java)
    val view = getView(parent,viewType,R.layout.item_menu_child)
    return MenuChildHolder(view)
  }
  
  override fun onBindViewHolder(holder: MenuChildHolder, position: Int) {
    val item = list?.get(position)
    var check = false
    
    holder.foodName.text = item?.foodName
    holder.foodIntroduce.text = item?.foodIntroduce
    holder.foodCost.text = FormatCurrency.FormatCurrencyVietNam(item?.foodCost)
    setImage(holder.foodImage,item?.foodImage)
    
    holder.containerLayout.setOnClickListener {
      navigateToFoodDetail(item?.foodId)
    }
    
    holder.addToCart.setOnClickListener {
      addToCart(item?.foodId)
    }
    holder.foodFavourite.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
      override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        check = !check
        holder.foodFavourite.isChecked = check
      }
    })
    
  }
  
  override fun getItemCount(): Int {
    return getSizeList(list)
  }
  
  private fun navigateToFoodDetail(id : Int?){
    val intent = Intent(context, FoodDetail::class.java)
    intent.putExtra(FOOD_ID,id)
    context.startActivity(intent)
  }
  
  fun addToCart(foodId : Int?){
  
  }
  
  
  private fun addToFavourite(foodId : Int?){
  
  }
  
  private fun removeFromFavourite(foodId : Int?){
 
  }
}