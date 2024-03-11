package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.UserInGroupHolder
import com.nsolution.nfood.Models.ItemUserInGroupDto
import com.nsolution.nfood.R

class UserInGroupAdapter(val listUser: ArrayList<ItemUserInGroupDto>?) :
  BaseAdapter<UserInGroupHolder>() {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInGroupHolder {
    val view = getView(parent,viewType, R.layout.item_avatar_order_group)
    return UserInGroupHolder(view)
  }
  
  override fun onBindViewHolder(holder: UserInGroupHolder, position: Int) {
    val user = listUser?.get(position)
    setImage(holder.userAvatar,user?.userAvatar)
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listUser)
  }
}