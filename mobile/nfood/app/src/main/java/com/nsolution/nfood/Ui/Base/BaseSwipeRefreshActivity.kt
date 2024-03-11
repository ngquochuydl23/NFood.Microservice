package com.nsolution.nfood.Ui.Base

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

abstract class BaseSwipeRefreshActivity : BaseActivity() {
  
  private lateinit var swipeRefresh: SwipeRefreshLayout
  
  fun getSwipeRefreshView(swipeRefresh: SwipeRefreshLayout) {
    this.swipeRefresh = swipeRefresh
    swipeRefresh.setOnRefreshListener {
      onRefreshListener()
    }
  }
  
  abstract fun onRefreshListener()
  
  open fun completeSwipeRefresh() {
    swipeRefresh.isRefreshing = false
  }
}