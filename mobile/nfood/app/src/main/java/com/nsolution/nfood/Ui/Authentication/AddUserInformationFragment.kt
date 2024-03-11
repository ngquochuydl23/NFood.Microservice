package com.nsolution.nfood.Ui.Authentication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfood.Models.ProfileDto
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IAccount

import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseFragment
import com.nsolution.nfood.Ui.CustomView.CustomDialog.LoadingDialog
import com.nsolution.nfood.Ui.Homescreen.Homescreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class AddUserInformationFragment : BaseFragment(), HttpClient {
  
  lateinit var service: IAccount
  lateinit var loadingDialog: LoadingDialog
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_add_user_information, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    service = retrofit.create(IAccount::class.java)
    initialView()
  }
  
  private fun initialView(){
    loadingDialog = LoadingDialog(context)
    loadingDialog.createDialog()
//    nextButton.setOnClickListener {
//      val profile = ProfileDto().apply {
//        fullname = enterFullName.text.toString()
//        email = enterEmail.text.toString()
//      }
//      addUserInformation(profile)
//    }
  }
  
  private fun addUserInformation(profile: ProfileDto){
    showLoadingDialog()
    val authorization = getAuthorization()
    service.addUserInformation(authorization,profile)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        navigateToHomescreen()
        dismissLoadingDialog()
      }, {
        dismissLoadingDialog()
        it.printStackTrace()
      })
    navigateToHomescreen()
  }
  
  private fun navigateToHomescreen() {
    val intent = Intent(context, Homescreen::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    requireActivity().finish()
  }
  
  private fun showLoadingDialog(){
    loadingDialog.showDialog()
  }
  
  private fun dismissLoadingDialog(){
    loadingDialog.dismiss()
  }
  
}
