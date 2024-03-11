package com.nsolution.nfood.Ui.MyFavourite


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.MyFavouriteAdapter
import com.nsolution.nfood.Models.ItemMenuChildDto
import com.nsolution.nfood.Models.ItemMyFavouriteDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class MyFavourite : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_favourite)
    initialView()
    getListFavourite()
  }
  
  private fun initialView(){
//    getBackActionBar(header,getString(R.string.my_favourite))
//    listMyFavourite.layoutManager = LinearLayoutManager(this)
  }
  
  private fun getListFavourite(){
  
    val menuChild = ItemMenuChildDto().apply {
      foodId = 1
      foodName = "Sữa tươi chân trâu đường đen"
      foodCost = 34000.0
      foodImage =
        "https://images.foody.vn/res/g26/252743/s/201844114119-sua-tuoi-frogcrash.jpg"
      foodIntroduce =
        "Vị ngọt đặc trưng của đường hồ hòa quyện với vị béo của sữa tươi và trân châu hoàng kim dẻo bùi đậm vị"
    }
    
    val itemMyFavourite = ItemMyFavouriteDto().apply {
      id = 1
      restaurantId = 1
      restaurantName = "Trà sữa R&B"
      restaurantAddress = "242 Bùi Thị Xuân, Phường 2, Thành phố Đà Lạt"
      restaurantWorkTime = "Open Sat 09:00 - 21:00"
      restaurantImage = "https://images.foody.vn/res/g68/673543/prof/s576x330/foody-upload-api-foody-mobile-40a-190508162534.jpg"
      listFavouriteFood  = arrayListOf(menuChild,menuChild)
    }
    //listMyFavourite.adapter = MyFavouriteAdapter(arrayListOf(itemMyFavourite,itemMyFavourite,itemMyFavourite))
    
  }
}
