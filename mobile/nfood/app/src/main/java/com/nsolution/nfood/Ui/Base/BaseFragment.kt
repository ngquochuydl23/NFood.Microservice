package com.nsolution.nfood.Ui.Base

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nsolution.nfood.SharedReferences.SaveToken

abstract class BaseFragment : Fragment() {
  
  var isNetworkConnected: Boolean = false
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    checkNetworkConnect()
  }
  
  open fun navigateTo(activity: Class<*>) {
    val intent = Intent(context, activity)
    startActivity(intent)
  }
  
  fun getTokenAuthFromDevice(): String? {
    return SaveToken(context).getData()
  }
  
  fun getAuthorization(): String {
    val token = getTokenAuthFromDevice()
    return "Bearer " + token
  }
  
  fun checkNetworkConnect() {
    val connectManager =
      context?.getSystemService(AppCompatActivity.CONNECTIVITY_SERVICE) as ConnectivityManager
    isNetworkConnected = connectManager.activeNetworkInfo != null && connectManager.activeNetworkInfo!!.isConnected
  }
  
  fun showBottomSheet(bottomSheet : BottomSheetDialogFragment){
    bottomSheet.show(childFragmentManager, bottomSheet.tag)
  }
}