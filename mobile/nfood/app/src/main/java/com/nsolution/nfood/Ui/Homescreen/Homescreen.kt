package com.nsolution.nfood.Ui.Homescreen

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.nsolution.nfood.Models.AccountDto
import com.nsolution.nfood.Models.ResultAction
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IProfile
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.CatchAccount
import com.nsolution.nfood.Singleton.ProfileSingleton
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.OrderWithGroup.AskJoinGroup
import com.nsolution.nfood.Ui.Restaurant.Restaurant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers


class Homescreen : BaseActivity(), HttpClient, FindLocationFragment.FindLocationListener {
  
  private val HomeFragment = HomeFragment()
  private val OrderFragment = OrderFragment()
  private val NotificationFragment = NotificationFragment()
  private val ProfileFragment = ProfileFragment()
  private val FindLocationFragment = FindLocationFragment()
  
  private val HomeFragmentTag = "HomeFragmentTag"
  private val OrderFragmentTag = "OrderFragmentTag"
  private val NotificationFragmentTag = "NotificationFragmentTag"
  private val ProfileFragmentTag = "ProfileFragmentTag"
  private val FindLocationFragmentTag = "FindLocationFragmentTag"
  
  private lateinit var service: IProfile
  private lateinit var header: View
  private lateinit var fragmentManager : FragmentManager
  private lateinit var fragmentTransaction : FragmentTransaction
  
  private var doubleBackToExitPressedOnce = false
  
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_homescreen)
    
    header = findViewById(R.id.header)
    
    initNofificationFirebase()
    
    initialView()
    initialService()
    getProfileFromServer()
  }
  
  private fun initialService() {
    service = retrofit.create(IProfile::class.java)
  }
  
  private fun initialView() {
    hideToolbar()
    hideBottomNavigationView()
    addFindLocationFragment()
    doubleBackToExitPressedOnce = true
    
//    bottomNavigationView.setOnNavigationItemSelectedListener {
//      when (it.itemId) {
//        R.id.home -> {
//          selectFragment(HomeFragment, HomeFragmentTag)
//          hideToolbar()
//          return@setOnNavigationItemSelectedListener true
//        }
//        R.id.order -> {
//          selectFragment(OrderFragment, OrderFragmentTag)
//          showToolbar()
//          setTitleToolbar(getString(R.string.order))
//          return@setOnNavigationItemSelectedListener true
//        }
//        R.id.notification -> {
//          selectFragment(NotificationFragment, NotificationFragmentTag)
//          showToolbar()
//          setTitleToolbar(getString(R.string.notification))
//          return@setOnNavigationItemSelectedListener true
//        }
//        R.id.profile -> {
//          selectFragment(ProfileFragment, ProfileFragmentTag)
//          showToolbar()
//          setTitleToolbar(getString(R.string.profile))
//          return@setOnNavigationItemSelectedListener true
//        }
//      }
//      return@setOnNavigationItemSelectedListener false
//    }
  }
  
  private fun selectFragment(selectFragment: Fragment, fragmentTag: String) {
    doubleBackToExitPressedOnce = selectFragment == HomeFragment
    fragmentManager = supportFragmentManager
    fragmentTransaction = fragmentManager.beginTransaction()
    
    val currentFragment = fragmentManager.primaryNavigationFragment
    var fragmentTemp = fragmentManager.findFragmentByTag(fragmentTag)
    if (currentFragment != null)
      fragmentTransaction.hide(currentFragment)
    
    if (fragmentTemp == null) {
      fragmentTemp = selectFragment
      fragmentTransaction.add(R.id.fragmentContainer, fragmentTemp, fragmentTag)
    } else fragmentTransaction.show(fragmentTemp)
    
    fragmentTransaction.setPrimaryNavigationFragment(fragmentTemp)
    fragmentTransaction.setReorderingAllowed(true)
    fragmentTransaction.commitNowAllowingStateLoss()
  }
  
  private fun showToolbar() {
    header.visibility = View.VISIBLE
  }
  
  private fun hideToolbar() {
    header.visibility = View.GONE
  }
  
  private fun setTitleToolbar(title: String?) {
    header.findViewById<TextView>(R.id.headerTitle).text = title.toString()
  }
  
  private fun getProfileFromServer() {
    val authorization = getAuthorization()
    service.getProfile(authorization)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe(resultProfile ,errorProfile)
  }
  
  private val errorProfile = Consumer<Throwable> {
    it.printStackTrace()
    
    val accountFromCache = getAccountFromCache()
    updateProfileWithSingleTon(accountFromCache)
  }
  
  private val resultProfile = Consumer <ResultAction<AccountDto>> {
    val result = it.result
    catchAccount(result)
    updateProfileWithSingleTon(result)
  }
  
  private fun catchAccount(account: AccountDto?) {
    if (account != null)
      CatchAccount(this).setData(account)
  }
  
  private fun getAccountFromCache(): AccountDto? {
    return CatchAccount(this).getData()
  }
  
  private fun updateProfileWithSingleTon(account: AccountDto?) {
    if (account != null)
      ProfileSingleton.instance.updateData(account)
  }
  
  override fun onBackPressed() {
    if (doubleBackToExitPressedOnce) {
      super.onBackPressed()
      return
    }
    hideToolbar()
    selectFragment(HomeFragment, HomeFragmentTag)
    //bottomNavigationView.selectedItemId = R.id.home
  }
  
  private fun initNofificationFirebase() {
    FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
      if (!task.isSuccessful) {
        Log.w(TAG, "Fetching FCM registration token failed", task.exception)
        return@OnCompleteListener
      }
    })
  }
  
  override fun onRemoveFragment() {
    showBottomNavigationView()
    selectFragment(HomeFragment, HomeFragmentTag)
    hideToolbar()
    onOpenWithDeepLink()
  }
  
  private fun hideBottomNavigationView() {
//    bottomNavigationView.visibility = View.GONE
//    shadow.visibility = View.GONE
  }
  
  private fun showBottomNavigationView() {
//    bottomNavigationView.visibility = View.VISIBLE
//    shadow.visibility = View.VISIBLE
  }
  
  private fun addFindLocationFragment() {
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.fragmentContainer, FindLocationFragment, FindLocationFragmentTag)
      .commit()
  }
  
  private fun onOpenWithDeepLink(){
    intent?.data.let {
      val restaurantId = it?.getQueryParameter("RestaurantId")
      val groupOrderId = it?.getQueryParameter("GroupOrderId")
      
      if(!restaurantId.isNullOrEmpty()){
        navigateTo(Restaurant::class.java)
        navigateTo(AskJoinGroup::class.java)
      }
    }
  }
}
