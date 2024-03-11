package com.nsolution.nfood.Ui.Authentication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nsolution.nfood.Models.ProfileDto
import com.nsolution.nfood.Models.RequestOtpDto
import com.nsolution.nfood.Models.VerificationRequestDto
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IAccount
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SaveToken
import com.nsolution.nfood.SharedReferences.SaveTokenOtp
import com.nsolution.nfood.Ui.CustomView.CustomDialog.LoadingDialog
import com.nsolution.nfood.Ui.Homescreen.Homescreen
import com.nsolution.nfood.ViewModels.RequestOtpViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class VerificationOtpFragment : Fragment(), HttpClient {
  
  lateinit var service: IAccount
  lateinit var loadingDialog: LoadingDialog
  private val resendTimeDuration: Long = 61000
  private var isCountDown: Boolean = false
  lateinit var timer: CountDownTimer
  private val viewModel: RequestOtpViewModel by activityViewModels()
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_verification_otp, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    service = retrofit.create(IAccount::class.java)
    initialView()
    
    viewModel.observerVerificationRequest().observe(viewLifecycleOwner, Observer { it ->
      updateMessageView(it.phonenumber)
      requestOtp(it)
    })
    
//    resendClick.setOnClickListener {
//
//    }
  }
  
  private fun initialView() {
    setResendTime()
    loadingDialog = LoadingDialog(context)
    loadingDialog.createDialog()
//    verifyButton.setOnClickListener {
//      val pinValue = getPinViewValue()
//      verifyOtpCode(pinValue)
//    }
//    resendClick.setOnClickListener {
//      setResendTime()
//    }
  }
  
  private fun updateMessageView(phonenumber : String?){
   // message.text = "Enter the OTP code we sent via SMS to your registed phone number ${phonenumber}"
  }
  
  private fun getPinViewValue(): String {
//    println(pinView.text.toString())
//    return pinView.text.toString()
    return "";
  }
  
  private fun saveTokenAuthToDevice(token: String?) {
    return SaveToken(context).setData(token)
  }
  
  private fun navigateToAddUserInformation() {
    findNavController().navigate(R.id.action_verificationOtpFragment_to_addUserInformationFragment)
  }
  
  private fun navigateToHomescreen() {
    val intent = Intent(context, Homescreen::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    requireActivity().finish()
  }
  
  private fun requestOtp(requestOtpInput: RequestOtpDto) {
    viewModel.clearViewModel()
//    service.requestOtp(requestOtpInput)
//      .observeOn(AndroidSchedulers.mainThread())
//      .subscribeOn(Schedulers.io())
//      .subscribe({
//        val result = it.result
//        resendTime.text = result?.resendTime.toString()
//        message.text = result?.message
//        saveTokenOtpToDevice(result?.token)
//      }, {
//        it.printStackTrace()
//      })
  }
  
  private fun verifyOtpCode(otpCode: String) {
    cancelCountTime()
    showLoadingDialog()
    
    val token = getTokenOtpFromDevice()
    val verificationRequest = VerificationRequestDto(otpCode)
    val authorization = "Bearer " + token
    
    service.verification(authorization, verificationRequest)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        dismissLoadingDialog()
        val result = it.result
        val profile = result?.account?.profile
        saveTokenAuthToDevice(result?.authToken)
        checkProfile(profile)
      }, {
        dismissLoadingDialog()
        it.printStackTrace()
      })
  }
  
  private fun checkProfile(profile: ProfileDto?) {
    if (profile?.fullname.isNullOrEmpty() && profile?.email.isNullOrEmpty()) {
      navigateToAddUserInformation()
    } else navigateToHomescreen()
  }
  
  private fun getTokenOtpFromDevice(): String? {
    return SaveTokenOtp(context).getData()
  }
  
  private fun saveTokenOtpToDevice(token: String?) {
    return SaveTokenOtp(context).setData(token)
  }
  
  private fun setResendTime() {
    resendTimeView()
    timer = object : CountDownTimer(resendTimeDuration, 1000) {
      override fun onTick(millisUntilFinished: Long) {
        isCountDown = true
        getTime(millisUntilFinished)
      }
      
      override fun onFinish() {
        finishResendTime()
      }
    }
    timer.start()
  }
  
  override fun onDestroyView() {
    cancelCountTime()
    super.onDestroyView()
  }
  
  private fun cancelCountTime() {
    if (isCountDown)
      timer.cancel()
  }
  
  private fun resendTimeView() {
//    resendClick.visibility = View.GONE
//    resendTime.visibility = View.VISIBLE
  }
  
  private fun finishResendTime() {
//    resendClick.visibility = View.VISIBLE
//    resendTime.visibility = View.GONE
    isCountDown = false
  }
  
  private fun getTime(time: Long) {
   // resendTime.text = convertLongToTime(time)
  }
  
  private fun convertLongToTime(time: Long): String {
    val format = String.format("%d sec", TimeUnit.MILLISECONDS.toSeconds(time))
    return format
  }
  
  private fun showLoadingDialog() {
    loadingDialog.showDialog()
  }
  
  private fun dismissLoadingDialog() {
    loadingDialog.dismiss()
  }
}
