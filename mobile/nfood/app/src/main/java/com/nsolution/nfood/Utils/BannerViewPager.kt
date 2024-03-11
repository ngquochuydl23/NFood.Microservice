package com.nsolution.nfood.Utils

import android.os.Handler
import androidx.viewpager.widget.ViewPager
import com.nsolution.nfood.Adapter.ViewPager.BannerPagerAdapter
import com.nsolution.nfood.Models.ItemBannerDto
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class BannerViewPager(

) : ViewPager.OnPageChangeListener {
  
  private lateinit var runnable: Runnable
  private var tabPosition = 0
  private lateinit var viewPager : ViewPager
  private lateinit var wormDotsIndicator : WormDotsIndicator
  private var listBanner : ArrayList<ItemBannerDto>? = null
  
  constructor(
    viewPagerParam: ViewPager,
    wormDotsIndicatorParam: WormDotsIndicator,
    listBannerParam: ArrayList<ItemBannerDto>?
  ) : this() {
    viewPager = viewPagerParam
    wormDotsIndicator = wormDotsIndicatorParam
    listBanner = listBannerParam
  
    viewPager.adapter = BannerPagerAdapter(listBanner)
    wormDotsIndicator.setViewPager(viewPager)
  
    runnable = Runnable {
      if (tabPosition == listBanner?.size) {
        tabPosition = 0
      }
      viewPager.currentItem = tabPosition
      tabPosition++
      Handler().postDelayed(runnable, 3000)
    }
    Handler().postDelayed(runnable, 3000)
    viewPager.addOnPageChangeListener(this)
  }
  
  override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
  
  }
  
  override fun onPageSelected(position: Int) {
    viewPager.currentItem = position
    tabPosition = position
  }
  
  override fun onPageScrollStateChanged(state: Int) {
  
  }
}