package com.nsolution.nfood.Ui.Authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nsolution.nfood.Models.RequestOtpDto
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IAccount
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.SaveTokenOtp
import com.nsolution.nfood.ViewModels.RequestOtpViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RequestOtpFragment : Fragment() {
  
  lateinit var viewModel: RequestOtpViewModel
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_request_otp, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }
  
  private fun initialView() {
//    nextButton.setOnClickListener {
//      val phonenumber = enterPhoneNumber.text.toString()
//      if (phonenumber.isNotEmpty()) {
//        val requestOtp = RequestOtpDto(phonenumber, selectCountryCode.selectedCountryCode)
//        updateViewModel(requestOtp)
//        navigateToVerificationFragment()
//      } else showToastMessage()
//    }
  }
  
  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel =
      ViewModelProvider(requireActivity()).get(RequestOtpViewModel::class.java)
    initialView()
  }
  
  private fun navigateToVerificationFragment() {
    findNavController().navigate(R.id.action_requestOtpFragment_to_verificationOtpFragment)
  }
  
  private fun updateViewModel(requestOtp: RequestOtpDto) {
    viewModel.setVerificationRequestViewModel(requestOtp)
  }
  
  private fun showToastMessage() {
    Toast.makeText(context, "Please enter the phone number", Toast.LENGTH_SHORT).show()
  }
}
