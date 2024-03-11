package com.nsolution.nfood.Ui.Collection

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.RestaurantVertiAdapter
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.ItemRestaurantVertiDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
//import kotlinx.android.synthetic.main.activity_collection_detail.*

class CollectionDetail : BaseActivity() {
  
  private val COLLECTION_ID = "COLLECTION_ID"
  private val COLLECTION_TITLE = "COLLECTION_TITLE"
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_collection_detail)
    initialView()
    getDetailCollection()
  }
  
  private fun initialView(){
    val collectionTitle = getTitleCollection()
    collapsingToolbarLayout(collectionTitle)
    //listRestaurant.layoutManager = LinearLayoutManager(this)
  }
  
  private fun getDetailCollection(){
//    Image(this).setImage(collectionImage,"https://scontent.fdad3-2.fna.fbcdn.net/v/t1.15752-9/s2048x2048/149581589_748881315744891_4814137521680383224_n.jpg?_nc_cat=107&ccb=3&_nc_sid=ae9488&_nc_ohc=K_qXkTXFt2MAX8ua8Or&_nc_ht=scontent.fdad3-2.fna&tp=7&oh=e99582684eb28ce343bd3268883d2a2e&oe=605267CC")
//    collectionTitle.text = "Let's Eat Pizza With Emily"
//    collectionSubtitle.text = "Delicious and nutritious"
//
//    val itemRestaurant = ItemRestaurantVertiDto().apply {
//      restaurantId = 1
//      deliveryTime = 23.0
//      restaurantImage = "https://images.foody.vn/res/g68/673543/prof/s576x330/foody-upload-api-foody-mobile-40a-190508162534.jpg"
//      restaurantName = "Trà sữa R&B"
//      restaurantRate = 4.5
//      distance = 5.0
//      restaurantType = "Vietnamese Food, Milk Tea, Snack"
//    }
//
//
//    listRestaurant.adapter = RestaurantVertiAdapter(arrayListOf(itemRestaurant,itemRestaurant,itemRestaurant,itemRestaurant,itemRestaurant),true)
//
  }
  
  private fun getTitleCollection() : String?{
    return intent.getStringExtra(COLLECTION_TITLE)
  }
  
}
