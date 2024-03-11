package com.nsolution.nfood.Ui.ViewAll

import android.os.Bundle
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
//import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAll : BaseActivity() {
  
  private val TITLE_VIEW_ALL = "TITLE_VIEW_ALL"
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_all)
    initialView()
  }
  
  private fun initialView(){
    val title = getTitleActionBar()!!
   // getBackActionBar(header,title)
  }
  
  private fun getTitleActionBar() : String?{
    return intent.getStringExtra(TITLE_VIEW_ALL)
  }
}
