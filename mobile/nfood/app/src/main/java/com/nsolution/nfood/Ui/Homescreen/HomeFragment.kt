package com.nsolution.nfood.Ui.Homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.CategoryAdapter
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.ListHomeAdapter
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.RestaurantVertiAdapter
import com.nsolution.nfood.Models.HomeContentDto
import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IHome
import com.nsolution.nfood.R
import com.nsolution.nfood.Singleton.LocationSingleton
import com.nsolution.nfood.Ui.Base.BaseFragment
import com.nsolution.nfood.Ui.Cart.Cart
import com.nsolution.nfood.Ui.CustomView.CustomBottomSheet.FilterBottomSheet
import com.nsolution.nfood.Ui.Search.Search
import com.nsolution.nfood.Ui.SelectLocation.SelectLocation
import com.nsolution.nfood.Utils.BannerViewPager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeFragment : BaseFragment(), HttpClient {
  
  lateinit var service: IHome
  lateinit var filterBottomShort: FilterBottomSheet
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_home, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    service = retrofit.create(IHome::class.java)
    filterBottomShort = FilterBottomSheet()
    
    initialView()
    getViewInternet(isNetworkConnected)
    
    LocationSingleton.instance.data.observe(viewLifecycleOwner, Observer {
      updateAddressView(it)
      //getHomeContent(it)
  
  
      // Clear homedemo.json file
      getHomeContentFake()
    })
  }
  
  private fun initialView() {
//    shimmerContain.visibility = View.GONE
//    layoutNoInternet.visibility = View.GONE
//    nestedScrollView.visibility = View.GONE
//
//    cart.visibility = View.GONE
//
//    listHome.layoutManager = LinearLayoutManager(context)
//    moreRestaurant.layoutManager = LinearLayoutManager(context)
//    listCategory.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//
//    searchLayout.setOnClickListener {
//      navigateTo(Search::class.java)
//    }
//    cart.setOnClickListener {
//      navigateTo(Cart::class.java)
//    }
//
//    currentAddress.setOnClickListener {
//      navigateTo(SelectLocation::class.java)
//    }
//
//    swipeRefreshLayout.setOnRefreshListener {
//      completeSwipeRefresh()
//    }
//
//    filterButton.setOnClickListener {
//      showBottomSheet(filterBottomShort)
//    }
  }
  
  private fun completeSwipeRefresh() {
    //swipeRefreshLayout.isRefreshing = false
  }
  
  private fun updateAddressView(location: LocationDto) {
    //currentAddress.text = location.address
  }
  
  private fun getHomeContent(location: LocationDto?) {
    val authentication = getTokenAuthFromDevice()
    
    //shimmerContain.visibility = View.VISIBLE
    //nestedScrollView.visibility = View.GONE
    
//    service.getHomeContent(authentication, location)
//      .observeOn(AndroidSchedulers.mainThread())
//      .subscribeOn(Schedulers.io())
//      .subscribe({
//        shimmerContain.visibility = View.GONE
//        nestedScrollView.visibility = View.VISIBLE
//        cart.visibility = View.VISIBLE
//        completeSwipeRefresh()
//        getResultData(it.result)
//      }, {
//        shimmerContain.visibility = View.GONE
//        completeSwipeRefresh()
//        it.printStackTrace()
//      })
    
  }
  
  private fun getResultData(homeContent: HomeContentDto?) {
//    BannerViewPager(viewPager, wormDotsIndicator, homeContent?.listBanner)
//    listCategory.adapter = CategoryAdapter(homeContent?.listCategory)
//    listHome.adapter = ListHomeAdapter(homeContent?.listHome)
//    moreRestaurant.adapter = RestaurantVertiAdapter(homeContent?.moreRestaurant, true)
  }
  
  private fun getViewInternet(isConnectInternet: Boolean) {
//    if (!isConnectInternet) {
//      layoutNoInternet.visibility = View.VISIBLE
//      nestedScrollView.visibility = View.GONE
//      cart.visibility = View.GONE
//    } else layoutNoInternet.visibility = View.GONE
  }
  
  
  private fun getHomeContentFake() {
//    shimmerContain.visibility = View.GONE
//    nestedScrollView.visibility = View.VISIBLE
//    cart.visibility = View.VISIBLE
//    completeSwipeRefresh()
    
    val value = resources.openRawResource(R.raw.homedemo)
    val reader = BufferedReader(InputStreamReader(value))
    val jsonValue = reader.readText()
    
    val jsonReader = JSONObject(jsonValue)
    
    
    val resultJson = jsonReader.getJSONObject("result")
    val stringBuilder = StringBuffer("${resultJson}")
    
    println(stringBuilder.toString())
    val result = Gson().fromJson(stringBuilder.toString(), HomeContentDto::class.java)
    getResultData(result)
  }
}
