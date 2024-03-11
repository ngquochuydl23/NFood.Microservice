package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.CategoryHolder
import com.nsolution.nfood.Models.ItemCategoryDto
import com.nsolution.nfood.R

class CategoryAdapter(val listCategory : ArrayList<ItemCategoryDto>?) : BaseAdapter<CategoryHolder>()  {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
    val view = getView(parent,viewType, R.layout.item_category)
    return CategoryHolder(view)
  }
  
  override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
    val itemCategory = listCategory?.get(position)
    
    holder.title.text = itemCategory?.title
    //setImage(holder.image,itemCategory?.image)
    
    holder.containerLayout.setOnClickListener {
    
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listCategory)
  }
  
}