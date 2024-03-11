package com.nsolution.nfood.Ui.Search

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.SearchResultAdapter
import com.nsolution.nfood.Models.ItemSearchResultDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class SearchResult : BaseActivity(), TextView.OnEditorActionListener {
  
  private val SEARCH_RESULT = "SEARCH_RESULT"
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search_result)
    initialView()
    initialData()
  }
  
  private fun initialView() {
//    toolbar.setNavigationOnClickListener {
//      finish()
//    }
//    listSearchResult.layoutManager = LinearLayoutManager(this)
  }
  
  private fun initialData() {
    val keyword = intent.getStringExtra(SEARCH_RESULT)
    setKeyword(keyword)
    getListSearchResult(keyword)
  }
  
  override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
//    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//      val searchText = searchBar.text.toString()
//      setKeyword(searchText)
//      getListSearchResult(searchText)
//      return true
//    }
    return false
  }
  
  private fun getListSearchResult(keyword: String?) {

    val item = ItemSearchResultDto().apply {
      RestaurantId = 1
      restaurantName = "KFC Camberwell - Church Street"
      restaurantType = "Fried Chicken - American - Fast Food"
      restaurantRate = 4.5
      restaurantImage = "https://d1ralsognjng37.cloudfront.net/a7002177-10a0-4cee-98e3-007e5805fc7e.jpeg"
      deliveryTimeAndDistance = "20 minutes - 7 km"
    }
    //listSearchResult.adapter = SearchResultAdapter(arrayListOf(item, item, item, item, item))
  }
  
  private fun setKeyword(keyword: String?) {
    //searchBar.setText(keyword)
  }
}
