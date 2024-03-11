package com.nsolution.nfood.Adapter.ViewPager

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.R

abstract class BasePagerAdapter : PagerAdapter() {
  
  lateinit var context: Context
  
  fun getView(container: ViewGroup,layout : Int) : ViewGroup {
    context = container.context
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    return inflater.inflate(layout, container, false) as ViewGroup
  }
  
  fun setImage(imageView: ImageView,imageUrl : String?){
    Image(context).setImage(imageView,imageUrl)
  }
}