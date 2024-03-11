package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Holder.MenuParentHolder
import com.nsolution.nfood.Models.ItemMenuParentDto
import com.nsolution.nfood.R

open class MenuParentAdapter(val listMenu : ArrayList<ItemMenuParentDto>?) : BaseAdapter<MenuParentHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuParentHolder {
    val view = getView(parent,viewType, R.layout.item_menu_parent)
    return MenuParentHolder(view)
  }
  
  override fun onBindViewHolder(holder: MenuParentHolder, position: Int) {
    val item = listMenu?.get(position)
    
    holder.menuTitle.text = item?.menuTitle
    holder.listFood.layoutManager = LinearLayoutManager(context)
    holder.listFood.adapter = MenuChildAdapter(item?.listFood)
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listMenu)
  }
}