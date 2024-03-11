package com.nsolution.nfood.Ui.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SaveToken
import com.nsolution.nfood.Ui.Authentication.AuthNavigationScreen
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.Homescreen.Homescreen


class SplashScreen : BaseActivity() {

  private val DELAY_MILLIS : Long = 2500
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash_screen)
    initialView()
  }
  
  private fun initialView(){
    setupWindow()
    val handler = Handler()
    handler.postDelayed(delayInMinutes, DELAY_MILLIS)
  }
  
  private fun setupWindow(){
    getWindow().setFlags(
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
  }
  
  private val delayInMinutes = Runnable{
    val token = SaveToken(this).getData()
    if(token.isNullOrEmpty())
      navigateToAuthentication()
    else navigateToHomescreen()
  }
  
  private fun navigateToHomescreen(){
    val intent = Intent(this, Homescreen::class.java)
    startActivity(intent)
    finish()
  }
  
  private fun navigateToAuthentication(){
    //val intent = Intent(this, AuthNavigationScreen::class.java)
    val intent = Intent(this, Homescreen::class.java)
    startActivity(intent)
    finish()
  }
}
