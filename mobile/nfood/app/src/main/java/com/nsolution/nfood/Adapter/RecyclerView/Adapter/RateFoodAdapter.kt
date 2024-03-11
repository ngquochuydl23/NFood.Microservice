package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.view.ViewGroup
import android.widget.ImageView
import com.nsolution.nfood.Adapter.RecyclerView.Holder.RateFoodHolder
import com.nsolution.nfood.Models.ItemRateFoodDto
import com.nsolution.nfood.R

class RateFoodAdapter(val list: ArrayList<ItemRateFoodDto>?) : BaseAdapter<RateFoodHolder>() {
  
  private val DisLike = -1
  private val Like = 1
  private val NonLike = 0
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateFoodHolder {
    val view = getView(parent,viewType, R.layout.item_rate_food)
    return RateFoodHolder(view)
  }
  
  override fun getItemCount(): Int {
    return getSizeList(list)
  }
  
  override fun onBindViewHolder(holder: RateFoodHolder, position: Int) {
    val item = list?.get(position)
    var isLike = item?.isLike
  
    setImage(holder.foodImage,item?.foodImage)
    
    holder.foodName.text = item?.foodName
    holder.likeButton.setOnClickListener {
      if(isLike == Like){
        isLike = NonLike
        nonLike(holder.likeButton,holder.dislikeButton)
      }
      else if(isLike == NonLike || isLike == DisLike) {
        isLike = Like
        likeAction(holder.likeButton,holder.dislikeButton)
      }
    }
    holder.dislikeButton.setOnClickListener {
      if(isLike == DisLike) {
        nonLike(holder.likeButton,holder.dislikeButton)
        isLike = NonLike
      }
      else if (isLike == NonLike ||  isLike == Like) {
        isLike = DisLike
        dislikeAction(holder.likeButton,holder.dislikeButton)
      }
    }
  }
  
  private fun nonLike(likeButton : ImageView, dislikeButton : ImageView){
    setColorButton(likeButton,R.color.like_unactive_backround,R.color.like_unactive)
    setColorButton(dislikeButton,R.color.like_unactive_backround,R.color.like_unactive)
  }
  
  private fun dislikeAction(likeButton : ImageView,dislikeButton : ImageView){
    setColorButton(dislikeButton,R.color.like_active_backround,R.color.like_active)
    setColorButton(likeButton,R.color.like_unactive_backround,R.color.like_unactive)
  }
  
  private fun likeAction(likeButton : ImageView,dislikeButton : ImageView){
    setColorButton(likeButton,R.color.like_active_backround,R.color.like_active)
    setColorButton(dislikeButton,R.color.like_unactive_backround,R.color.like_unactive)
  }
  
  private fun setColorButton(button : ImageView,backgroundColor : Int,imageColor : Int){
    button.backgroundTintList = context.resources?.getColorStateList(backgroundColor)
    button.imageTintList = context.resources?.getColorStateList(imageColor)
  }
}