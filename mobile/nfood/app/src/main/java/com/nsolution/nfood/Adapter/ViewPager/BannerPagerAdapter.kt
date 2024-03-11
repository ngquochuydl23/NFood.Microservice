package com.nsolution.nfood.Adapter.ViewPager


import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.nsolution.nfood.Models.ItemBannerDto
import com.nsolution.nfood.R

open class BannerPagerAdapter(val listBanner : ArrayList<ItemBannerDto>?) : BasePagerAdapter() {
  
  override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view == `object`
  }
  
  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val view = getView(container,R.layout.item_banner)
    val image = view.findViewById<ImageView>(R.id.image)
    
    val item = listBanner?.get(position)
    
    setImage(image,item?.image)
    container.addView(view)
    return view
  }
  
  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }
  
  override fun getCount(): Int {
    if(!listBanner.isNullOrEmpty())
      return listBanner.size
    return 0
  }
}