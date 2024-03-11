package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nsolution.nfood.Adapter.RecyclerView.Holder.ListHomeHolder
import com.nsolution.nfood.Models.ItemListHomeDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.ViewAll.ViewAll

class ListHomeAdapter(val list: ArrayList<ItemListHomeDto>?) :
  BaseAdapter<ListHomeHolder>() {
  
  private val RESTAURANT = "restaurant"
  private val FOOD = "food"
  private val COLLECTION = "collection"
  private val VIEW_ALL_ID = "VIEW_ALL_ID"
  private val TITLE_VIEW_ALL = "TITLE_VIEW_ALL"
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHomeHolder {
    val view = getView(parent, viewType, R.layout.item_list_home)
    return ListHomeHolder(view)
  }
  
  override fun onBindViewHolder(holder: ListHomeHolder, position: Int) {
    val item = list?.get(position)
    holder.seeAll.visibility = View.GONE
    
    holder.title.text = item?.title
    holder.subtitle.text = item?.subtitle
    
    holder.listHome.layoutManager =
      LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    
    if (item?.type == RESTAURANT) {
      holder.listHome.adapter = RestaurantHoriAdapter(item.listRestaurant)
      holder.seeAll.visibility = View.VISIBLE
    } else if (item?.type == FOOD) {
      holder.listHome.layoutManager =
        GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)
      holder.listHome.adapter = FoodAdapter(item.listFood)
    } else if (item?.type == COLLECTION)
      holder.listHome.adapter = CollectionAdapter(item.listCollection)
    
    holder.seeAll.setOnClickListener {
      navigateToViewAll(item?.id, item?.title)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(list)
  }
  
  private fun navigateToViewAll(id: Int?, title: String?) {
    val intent = Intent(context, ViewAll::class.java)
    intent.putExtra(VIEW_ALL_ID, id)
    intent.putExtra(TITLE_VIEW_ALL, title)
    context.startActivity(intent)
  }
}