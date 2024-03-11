package com.nsolution.nfood.Ui.Authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nsolution.nfood.R
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment() {
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_welcome, container, false)
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }
  
  private fun initialView(){
//    gettingStartedButton.setOnClickListener {
//      findNavController().navigate(R.id.action_welcomeFragment_to_requestOtpFragment)
//    }
  }
}
