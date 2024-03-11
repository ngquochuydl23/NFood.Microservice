package com.nsolution.nfood.Ui.Homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.ViewPager.OrderPagerAdapter

import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseFragment


class OrderFragment : BaseFragment() {
 
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_order, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  
//    tabLayout.setupWithViewPager(viewPager)
//    viewPager.adapter = OrderPagerAdapter(childFragmentManager)
    //viewPager.offscreenPageLimit = 2
  }
}
