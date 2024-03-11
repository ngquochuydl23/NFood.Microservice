package com.nsolution.nfood.Adapter.ViewPager

import android.view.View
import android.view.ViewGroup
import com.nsolution.nfood.Models.AskJoinGroupDto
import com.nsolution.nfood.R

open class AskJoinGroupPagerAdapter(val askJoinGroup: AskJoinGroupDto) : BasePagerAdapter() {
  
  private val PageNumber = 3
  private val FirstPage = 0
  private val SecondPage = 1
  private val ThirdPage = 2
  
  override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view == `object`
  }
  
  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val view = getView(container, R.layout.layout_ask_join_group_contain)
    
    val askJoinGroupPage1 = view.findViewById<View>(R.id.askJoinGroupPage1)
    val askJoinGroupPage2 = view.findViewById<View>(R.id.askJoinGroupPage2)
    val askJoinGroupPage3 = view.findViewById<View>(R.id.askJoinGroupPage3)
    
    when(position){
      FirstPage -> {
        // Show askJoinGroupPage1
        // Hide the other two page
        askJoinGroupPage1.visibility = View.VISIBLE
        askJoinGroupPage2.visibility = View.GONE
        askJoinGroupPage3.visibility = View.GONE
      }
      SecondPage -> {
        // Show askJoinGroupPage2
        // Hide the other two page
        askJoinGroupPage1.visibility = View.GONE
        askJoinGroupPage2.visibility = View.VISIBLE
        askJoinGroupPage3.visibility = View.GONE
      }
      ThirdPage -> {
        // Show askJoinGroupPage3
        // Hide the other two page
        askJoinGroupPage1.visibility = View.GONE
        askJoinGroupPage2.visibility = View.GONE
        askJoinGroupPage3.visibility = View.VISIBLE
      }
    }
    
    container.addView(view)
    return view
  }
  
  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }
  
  override fun getCount(): Int {
    return PageNumber
  }
}