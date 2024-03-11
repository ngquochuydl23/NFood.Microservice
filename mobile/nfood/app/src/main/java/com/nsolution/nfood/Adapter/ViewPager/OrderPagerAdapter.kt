package com.nsolution.nfood.Adapter.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.nsolution.nfood.Ui.Homescreen.PastOrderFragment
import com.nsolution.nfood.Ui.Homescreen.UpcomingOrderFragment

class OrderPagerAdapter(fragmentManager: FragmentManager) :
  FragmentStatePagerAdapter(fragmentManager) {
  
  val pastOrderFragment = PastOrderFragment()
  val upcomingOrderFragment = UpcomingOrderFragment()
  
  val listFragment
          = arrayListOf(pastOrderFragment, upcomingOrderFragment)
  
  val listFragmentTitle = arrayListOf(
    "Past Orders",
    "Upcoming"
  )
  
  override fun getCount(): Int {
    return listFragment.size
  }
  
  override fun getItem(position: Int): Fragment {
    return listFragment.get(position)
  }
  
  override fun getPageTitle(position: Int): CharSequence? {
    return listFragmentTitle.get(position)
  }
}