package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.WorkTimeHolder
import com.nsolution.nfood.Models.ItemWorkTimeDto
import com.nsolution.nfood.R

class WorkTimeAdapter(val listWorkTime : ArrayList<ItemWorkTimeDto>?) : BaseAdapter<WorkTimeHolder>(){
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkTimeHolder {
    val view = getView(parent,viewType, R.layout.item_work_time)
    return WorkTimeHolder(view)
  }
  
  override fun onBindViewHolder(holder: WorkTimeHolder, position: Int) {
    val itemWorkTime = listWorkTime?.get(position)
    
    holder.dayOfWeek.text = itemWorkTime?.dayOfWeek
    holder.workTime.text = itemWorkTime?.workTime
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listWorkTime)
  }
  
}