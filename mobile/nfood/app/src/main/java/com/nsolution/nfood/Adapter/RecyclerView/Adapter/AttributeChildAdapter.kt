package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.nsolution.nfood.Adapter.RecyclerView.Holder.AttributeChildHolder
import com.nsolution.nfood.Models.ItemAttributeChildDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Currency.FormatCurrency

class AttributeChildAdapter(val listAttribute: ArrayList<ItemAttributeChildDto>?) :
  BaseAdapter<AttributeChildHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeChildHolder {
    val view = getView(parent, viewType, R.layout.item_attribute_child)
    return AttributeChildHolder(view)
  }
  
  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: AttributeChildHolder, position: Int) {
    val itemAttribute = listAttribute?.get(position)
    
    holder.attributeName.text = itemAttribute?.attributeName
    holder.attributePrice.text =
      "+ " + FormatCurrency.FormatCurrencyVietNam(itemAttribute?.attributePrice)
    
    var check = itemAttribute?.isSelected!!
    
    holder.selectButton.setOnClickListener {
      check = !check
      holder.isSelected.isChecked = check
      itemAttribute.isSelected = check
      if (check) {
        setTextColorSelected(holder.attributeName)
        setTextColorSelected(holder.attributePrice)
      } else {
        setTextColorUnSelected(holder.attributeName)
        setTextColorUnSelected(holder.attributePrice)
      }
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listAttribute)
  }
  
  
  fun selectAttribute() {
  
  }
  
  private fun setTextColorSelected(textView: TextView) {
    textView.setTextColor(ContextCompat.getColor(context, R.color.titleTextColor))
  }
  
  private fun setTextColorUnSelected(textView: TextView) {
    textView.setTextColor(ContextCompat.getColor(context, R.color.textColorPrimary))
  }
}