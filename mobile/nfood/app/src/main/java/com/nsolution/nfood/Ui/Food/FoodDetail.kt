package com.nsolution.nfood.Ui.Food

import android.graphics.Paint
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.AttributeParentAdapter
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.ItemAttributeChildDto
import com.nsolution.nfood.Models.ItemAttributeParentDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.Restaurant.Restaurant


class FoodDetail : BaseActivity() {
  
  private val FOOD_ID = "FOOD_ID"
  private val CART_ID = "CART_ID"
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_food_detail)
    initialView()
    initialData()
  }
  
  private fun initialView() {
//    foodCost.paintFlags = foodCost.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//    listAttributeParent.layoutManager = LinearLayoutManager(this)
//    collapsingToolbarLayout("Classic Hamburger")
//    Image(this).setImage(foodImage,"https://cdn.shopify.com/s/files/1/0269/5967/5490/products/6.2.jpg")
//
//    addCartButton.setOnClickListener {
//      //showBottomSheet(Restaurant.startNewOrderBottomSheet)
//      finish()
//
//
//    }
  }
  
  private fun getIdFood(): Int {
    return intent.getIntExtra(FOOD_ID, 0)
  }
  
  private fun getIdCart(): Int {
    return intent.getIntExtra(CART_ID, 0)
  }
  
  private fun initialData() {
    val idFood = getIdFood()
    getDetailFood(idFood)
    
    val idCart = getIdCart()
    if (idCart > 0)
      getStateFood(idCart)
  }
  
  private fun getDetailFood(idFood: Int?) {
//    foodDisciption.text =
//      "Two extra-large eggs, fried and simmered in hot sauce. Served on a tortilla with rice and homemade refried beans. Substitute milder homemade Spanish sauce for hot sauce. Mexican breakfasts include hot sauce, homemade refried beans, Spanish rice, guacamole, sour cream, and fresh roasted jalapeno."
//
    val attributeChild1 = ItemAttributeChildDto().apply {
      id = 1
      attributeName = "Small"
      attributePrice = 5000.0
      isSelected = false
    }
  
    val attributeChild2 = ItemAttributeChildDto().apply {
      id = 1
      attributeName = "Medium"
      attributePrice = 5000.0
      isSelected = false
    }
  
    val attributeChild3 = ItemAttributeChildDto().apply {
      id = 1
      attributeName = "Large"
      attributePrice = 5000.0
      isSelected = false
    }
    
    val attributeParent = ItemAttributeParentDto().apply {
      id = 1
      attributeParentName = "Size"
      attributeMaxSelect = 1
      attributeType = "Required"
      listAttributeChild =
        arrayListOf(attributeChild1, attributeChild2, attributeChild3)
    }
    
//    listAttributeParent.adapter =
//      AttributeParentAdapter(arrayListOf(attributeParent, attributeParent, attributeParent))
  }
  
  private fun getStateFood(idCart: Int?) {
  
  }
  
  private fun enableButton() {
//    addCartButton.backgroundTintList = resources.getColorStateList(R.color.green)
//    addCartButton.isEnabled = true
  }
  
  private fun disableButton() {
//    addCartButton.backgroundTintList = resources.getColorStateList(R.color.whitesmoke)
//    addCartButton.isEnabled = false
  }
  
  private fun updateStateFoodToServer() {
  
  }
}
