package com.nsolution.nfood.Ui.Authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity

class AuthNavigationScreen : BaseActivity() {
  
  private lateinit var appBarConfiguration: AppBarConfiguration
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_auth_navigation_screen)
    initialView()
  }
  
  private fun initialView(){
    val navController = findNavController(R.id.navHostFragment)
    appBarConfiguration = AppBarConfiguration(navController.graph)
    //toolbar.setupWithNavController(navController, appBarConfiguration)
  }
  
//  override fun onSupportNavigateUp(): Boolean {
//    return NavHostFragment.findNavController(navHostFragment).navigateUp()
//  }
}
