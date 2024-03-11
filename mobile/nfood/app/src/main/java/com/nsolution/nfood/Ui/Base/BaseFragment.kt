package com.nsolution.nfood.Ui.Base

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SaveToken

abstract class BaseFragment : Fragment() {
  
  private var viewResource : Int? = null;
  
  var isNetworkConnected: Boolean = false
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
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
  
  fun showBottomSheet(bottomSheet : BottomSheetDialogFragment){
    bottomSheet.show(childFragmentManager, bottomSheet.tag)
  }
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_find_location, container, false)
  }
}