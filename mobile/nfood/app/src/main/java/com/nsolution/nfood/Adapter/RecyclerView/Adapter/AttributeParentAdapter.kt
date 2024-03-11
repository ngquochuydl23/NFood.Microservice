package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Holder.AttributeParentHolder
import com.nsolution.nfood.Models.ItemAttributeParentDto
import com.nsolution.nfood.R

class AttributeParentAdapter(val listAttribute: ArrayList<ItemAttributeParentDto>?) :
  BaseAdapter<AttributeParentHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeParentHolder {
    val view = getView(parent,viewType, R.layout.item_attribute_parent)
    return AttributeParentHolder(view)
  }
  
  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: AttributeParentHolder, position: Int) {
    val itemAttribute = listAttribute?.get(position)
    
    holder.attributeParentName.text = itemAttribute?.attributeParentName
    holder.attributeType.text = itemAttribute?.attributeType
    holder.attributeMaxSelect.text = "\u2022 Select " + itemAttribute?.attributeMaxSelect.toString()
    
    holder.listAttributeChild.layoutManager = LinearLayoutManager(context)
    holder.listAttributeChild.adapter = AttributeChildAdapter(itemAttribute?.listAttributeChild)
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listAttribute)
  }
  
}