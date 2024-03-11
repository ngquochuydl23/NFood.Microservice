package com.nsolution.nfood.Ui.Search

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.SearchHistoryAdapter
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SearchHistorySharedPreferences
import com.nsolution.nfood.Ui.Base.BaseActivity


class Search : BaseActivity(), TextView.OnEditorActionListener {
  
  private val SEARCH_RESULT = "SEARCH_RESULT"
  private var searchHistorySharedPreferences : SearchHistorySharedPreferences? = null
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search)
    
    
    initialView()
    getListSearchHistory()
  }
  
  private fun initialView() {
//    listSearchHistory.layoutManager = LinearLayoutManager(this)
//    toolbar.setNavigationOnClickListener {
//      finish()
//    }
//    searchBar.requestFocus()
//    searchAction()
  }
  
  private fun searchAction() {
   // searchBar.setOnEditorActionListener(this)
  }
  
  override fun onEditorAction(textView: TextView?, actionId: Int, event: KeyEvent?): Boolean {
    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
      searchResult()
      return true
    }
    return false
  }
  
  private fun searchResult() {
//    if (searchBar.text.isEmpty())
//      return
//    searchBar.clearFocus()
//    val keyword: String = searchBar.text.toString()
//    SearchHistorySharedPreferences(this).addSearchHistory(keyword)
//    Intent(this, SearchResult::class.java).also { intent ->
//      intent.putExtra(SEARCH_RESULT, keyword)
//      startActivity(intent)
//    }
//    finish()
  }
  
  private fun getListSearchHistory(){
    val searchHistoryData = SearchHistorySharedPreferences(this).getData()
    //listSearchHistory.adapter = SearchHistoryAdapter(searchHistoryData)
  }
}
