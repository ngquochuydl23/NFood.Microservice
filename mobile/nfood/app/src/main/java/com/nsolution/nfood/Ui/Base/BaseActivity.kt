package com.nsolution.nfood.Ui.Base

import android.content.Intent
import android.net.ConnectivityManager
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SaveToken

abstract class BaseActivity : AppCompatActivity() {
  
  open fun getActionBar(toolbarLayout: View, titleActionBar: String) {
    val toolbar = toolbarLayout.findViewById<Toolbar>(R.id.toolbar)
    val headerTitle = toolbarLayout.findViewById<TextView>(R.id.headerTitle)
    headerTitle.text = titleActionBar
    
    toolbar.setNavigationOnClickListener {
      getNavigationClick()
    }
  }
  
  open fun getNavigationClick() {
    finish()
  }
  
  open fun getBackActionBar(toolbarLayout: View, titleActionBar: String?) {
    if (!titleActionBar.isNullOrEmpty())
      getActionBar(toolbarLayout, titleActionBar)
    toolbarLayout.findViewById<Toolbar>(R.id.toolbar).setNavigationIcon(R.drawable.icon_back)
  }
  
  open fun getBackActionBarWithoutTitle(toolbarLayout: Toolbar) {
    toolbarLayout.setNavigationOnClickListener {
      finish()
    }
  }
  
  open fun navigateTo(activity: Class<*>) {
    val intent = Intent(this, activity)
    startActivity(intent)
  }
  
  fun getTokenAuthFromDevice(): String? {
    return SaveToken(this).getData()
  }
  
  fun getAuthorization(): String {
    val token = getTokenAuthFromDevice()
    return "Bearer " + token
  }
  
  fun isNetworkConnected(): Boolean {
    val connectManager =
      getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectManager.activeNetworkInfo != null && connectManager.activeNetworkInfo!!.isConnected
  }
  
  open fun collapsingToolbarLayout(title : String?) {
    val collapseTitle = findViewById<TextView>(R.id.collapseTitle)
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)
  
    toolbar.setNavigationOnClickListener {
      finish()
    }
    
    collapseTitle.visibility = View.GONE
    collapseTitle.text = title
    
    appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
      var scrollRange = -1
      var isShow = false
      override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (scrollRange == -1)
          scrollRange = appBarLayout?.totalScrollRange!!
        if (verticalOffset + scrollRange == 0) {
          isShow = true
          collapseTitle.visibility = View.VISIBLE
        } else if(isShow){
          isShow = false
          collapseTitle.visibility = View.GONE
        }
      }
    })
  }
  
  fun showBottomSheet(bottomSheet : BottomSheetDialogFragment){
    bottomSheet.show(supportFragmentManager, bottomSheet.tag)
  }
}