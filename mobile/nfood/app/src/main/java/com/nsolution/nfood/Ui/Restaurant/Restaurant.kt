package com.nsolution.nfood.Ui.Restaurant

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.MenuParentAdapter
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.UserInGroupAdapter
import com.nsolution.nfood.Adapter.RecyclerView.Holder.MenuParentHolder
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.ItemMenuChildDto
import com.nsolution.nfood.Models.ItemMenuParentDto
import com.nsolution.nfood.Models.ItemUserInGroupDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.Cart.Cart
import com.nsolution.nfood.Ui.CustomView.CustomBottomSheet.StartNewOrderBottomSheet
import com.nsolution.nfood.Ui.OrderWithGroup.IntroduceOrderWithGroup


class Restaurant : BaseActivity(), AppBarLayout.OnOffsetChangedListener {
  
  private val IS_APPBAR_COLLAPSED = 0
  private val IS_APPBAR_EXPANDED = -1
  
  lateinit var orderWithGroup: View
  lateinit var listUserInGroup: RecyclerView
  lateinit var startNewOrderBottomSheet: StartNewOrderBottomSheet
  
  private var scrollRange = -1
  private var isShow = false
  
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_restaurant)
  
    startNewOrderBottomSheet = StartNewOrderBottomSheet()
    
    orderWithGroup = findViewById(R.id.orderWithGroup)
    listUserInGroup = findViewById(R.id.listUserInGroup)
    
    initialView()
    initialData()
    
    getListUserInGroup()
    setMenuTabLayout()
  }
  
  private fun initialView() {
//    listMenu.layoutManager = LinearLayoutManager(this)
//    listUserInGroup.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
//    collapsingToolbarLayout("KFC Camberwell - Church Street")
//
//    currentCartButton.setOnClickListener {
//      navigateTo(Cart::class.java)
//    }
//
//    moreInformation.setOnClickListener {
//      navigateTo(RestaurantDetail::class.java)
//    }
//
//    orderWithGroup.setOnClickListener {
//      navigateTo(IntroduceOrderWithGroup::class.java)
//    }
  }
  
  override fun collapsingToolbarLayout(headerTitle: String?) {
//    toolbar.setNavigationOnClickListener {
//      finish()
//    }
    
//    collapseTitle.visibility = View.GONE
//    tabLayout.visibility = View.GONE
//    collapseTitle.text = headerTitle
//    appBarLayout.addOnOffsetChangedListener(this)
  }
  
  override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
    if (scrollRange == IS_APPBAR_EXPANDED) {
      scrollRange = appBarLayout?.totalScrollRange as Int
    }
    if (verticalOffset + scrollRange == IS_APPBAR_COLLAPSED) {
      isShow = true
  
      collapseUI()
    } else if (isShow) {
      isShow = false
      expandUI()
    }
  }
  
  private fun expandUI(){
//    collapseTitle.visibility = View.GONE
//    tabLayout.visibility = View.GONE
  }
  
  private fun collapseUI(){
//    collapseTitle.visibility = View.VISIBLE
//    tabLayout.visibility = View.VISIBLE
  }
  
  private fun setMenuTabLayout() {
//    listMenu.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//
//      override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//        super.onScrollStateChanged(recyclerView, newState)
//        val currentPosition =
//          (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
//        tabLayout.setScrollPosition(currentPosition, 0f, true)
//      }
//    })
  }
  
  private fun initialData() {
//    Image(this).setImage(restaurantImage,"https://cdn.concreteplayground.com/content/uploads/2020/04/Family-Feast-KFC-supplied.jpg")
//
//    val menuChild = ItemMenuChildDto().apply {
//      foodId = 1
//      foodName = "Classic Hamburger"
//      foodCost = 34000.0
//      foodImage =
//        "https://cdn.shopify.com/s/files/1/0269/5967/5490/products/6.2.jpg"
//      foodIntroduce =
//        "Two extra-large eggs, fried and simmered in hot sauce. Served on a tortilla with rice and homemade refried beans. Substitute milder homemade Spanish sauce for hot sauce. Mexican breakfasts include hot sauce, homemade refried beans, Spanish rice, guacamole, sour cream, and fresh roasted jalapeno."
//    }
//
//    val menuParent = ItemMenuParentDto().apply {
//      menuId = 1
//      menuTitle = "Slot Player Breakfast"
//      listFood = arrayListOf(menuChild, menuChild, menuChild, menuChild, menuChild)
//    }
//
//    val list = arrayListOf(menuParent, menuParent, menuParent, menuParent, menuParent)
//    listMenu.adapter = MenuParentAdapter(list)
//    for (itemMenuChild in list) {
//      tabLayout.addTab(tabLayout.newTab().setText(itemMenuChild.menuTitle))
//    }
  }
  
  private fun getListUserInGroup() {
    
    val userInGroupDto = ItemUserInGroupDto().apply {
      userId = 1
      userAvatar = "https://deadline.com/wp-content/uploads/2019/09/emily-in-paris-4.jpg"
    }
    
    listUserInGroup.adapter =
      UserInGroupAdapter(arrayListOf(userInGroupDto, userInGroupDto, userInGroupDto))
  }
}
