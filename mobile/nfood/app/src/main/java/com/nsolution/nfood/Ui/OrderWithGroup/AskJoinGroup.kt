package com.nsolution.nfood.Ui.OrderWithGroup

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.nsolution.nfood.Adapter.ViewPager.AskJoinGroupPagerAdapter
import com.nsolution.nfood.Models.AskJoinGroupDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class AskJoinGroup : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_ask_join_group)
    initialView()
  }
  
  private fun initialView(){
    val joinGroup = AskJoinGroupDto()
//
//    viewPager.adapter = AskJoinGroupPagerAdapter(joinGroup)
//    wormDotsIndicator.setViewPager(viewPager)
//
//    joinGroupButton.setOnClickListener {
//      navigateTo(OrderWithGroup::class.java)
//      finish()
//    }
  }
}
