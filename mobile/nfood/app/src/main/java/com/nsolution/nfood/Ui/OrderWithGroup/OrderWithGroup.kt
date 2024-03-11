package com.nsolution.nfood.Ui.OrderWithGroup

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.OrderWithGroupAdapter
import com.nsolution.nfood.Models.ItemOrderGroupDto
import com.nsolution.nfood.Models.ItemOrderSummaryDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.Cart.Cart


class OrderWithGroup : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order_with_group)
    initialView()
    initialData()
  }
  
  private fun initialView() {
//    getBackActionBarWithoutTitle(toolbar)
//    orderGroups.layoutManager = LinearLayoutManager(this)
//
//    acceptOrderButton.setOnClickListener {
//      navigateTo(Cart::class.java)
//    }
//
//    addGuestButton.setOnClickListener {
//      inviteFriend()
//    }
  }
  
  private fun initialData() {
    getListOrderGroup()
  }
  
  private fun getListOrderGroup() {
    val itemSummary = ItemOrderSummaryDto().apply {
      foodName = "Classic Hamburger"
      foodAttributes = "No Egg\nSmall"
      foodCost = 34000.0
      quanlity = 1
    }
    
    val orderGroupMe = ItemOrderGroupDto().apply {
      isMe = true
      isRoomOwner = true
      userName = "Meo Ami"
      userAvatar =
        "https://scontent-hkt1-2.xx.fbcdn.net/v/t1.15752-9/156423123_572820707012607_6115539149328030167_n.png?_nc_cat=106&ccb=3&_nc_sid=ae9488&_nc_ohc=Caf9MtPeSl4AX-OyJ6r&_nc_ht=scontent-hkt1-2.xx&oh=f28dbb3b5b4354033e0d04c4fffea242&oe=6066A888"
      listSummaryFood = arrayListOf(itemSummary, itemSummary)
    }
    
    val orderGroupFriend = ItemOrderGroupDto().apply {
      isMe = false
      isRoomOwner = false
      userName = "Emily"
      userAvatar = "https://deadline.com/wp-content/uploads/2019/09/emily-in-paris-4.jpg"
      listSummaryFood = arrayListOf(itemSummary, itemSummary)
    }
   // orderGroups.adapter = OrderWithGroupAdapter(arrayListOf(orderGroupMe, orderGroupFriend))
    
  }
  
  private fun inviteFriend(){
    val linkInviteFriend = getLinkInviteFriend()
    
    val sendIntent = Intent().apply {
      action = Intent.ACTION_SEND
      type = "text/plain"
      putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
      putExtra(Intent.EXTRA_TEXT, linkInviteFriend)
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)
  }
  
  private fun getLinkInviteFriend() : String? {
    val idGroup = 1
    val link = "http://nfood.com/order-with-group/1"
    return link
  }
}
