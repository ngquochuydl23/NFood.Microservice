package com.nsolution.nfood.Ui.InviteFriend

import android.content.Intent
import android.os.Bundle
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity


class InviteFriend : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_invite_friend)
    initialView()
  }
  
  private fun initialView(){
   // getBackActionBarWithoutTitle(toolbar)
//    inviteFriend.setOnClickListener {
//      inviteFriend()
//    }
  }
  
  private fun inviteFriend(){
    val sendIntent: Intent = Intent().apply {
      action = Intent.ACTION_SEND
      type = "text/plain"
      putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
      putExtra(Intent.EXTRA_TEXT, getString(R.string.invite_link))
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)
  }
}
