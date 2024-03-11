package com.nsolution.nfood.Ui.Homescreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.ProfileDto
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SaveToken
import com.nsolution.nfood.Singleton.ProfileSingleton
import com.nsolution.nfood.Ui.Authentication.AuthNavigationScreen
import com.nsolution.nfood.Ui.Base.BaseFragment
import com.nsolution.nfood.Ui.InviteFriend.InviteFriend
import com.nsolution.nfood.Ui.MyFavourite.MyFavourite
import com.nsolution.nfood.Ui.Setting.Setting
import com.nsolution.nfood.Ui.Setting.UpdateProfile


class ProfileFragment : BaseFragment() {
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_profile, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
    getProfile()
  }
  
  private fun initialView() {
//    avatarContainer.setOnClickListener {
//      navigateTo(UpdateProfile::class.java)
//    }
//
//    settingButon.setOnClickListener {
//      navigateTo(Setting::class.java)
//    }
//
//    myFavouriteButton.setOnClickListener {
//      navigateTo(MyFavourite::class.java)
//    }
//
//    inviteFriendButton.setOnClickListener {
//      navigateTo(InviteFriend::class.java)
//    }
//
//    signOutButton.setOnClickListener {
//      clearTokenFromDevice()
//      signOutAction()
//    }
    
  }
  
  private fun clearTokenFromDevice() {
    SaveToken(context).deleteData()
  }
  
  private fun signOutAction() {
    navigateToAuthNavigationScreen()
  }
  
  private fun navigateToAuthNavigationScreen() {
    val intent = Intent(context, AuthNavigationScreen::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    activity?.finish()
  }
  
  private fun getProfile(){
    ProfileSingleton.instance.profile.observe(viewLifecycleOwner, Observer {
      applyUserView(it.profile)
    })
  }
  
  private fun applyUserView(profile : ProfileDto?){
    //Image(context).setAvatar(avatar,profile?.avatar)
    //fullname.text = profile?.fullname
  }
}
