package com.nsolution.nfood.Ui.Setting

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import com.nsolution.nfood.Image.Image
import com.nsolution.nfood.Models.AccountDto
import com.nsolution.nfood.Models.ProfileDto
import com.nsolution.nfood.Models.UpdateProfileDto
import com.nsolution.nfood.Network.HttpClient
import com.nsolution.nfood.Network.InterfaceService.IProfile
import com.nsolution.nfood.R
import com.nsolution.nfood.SharedReferences.CatchAccount
import com.nsolution.nfood.Singleton.ProfileSingleton
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.CustomView.CustomDialog.LoadingDialog
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException

class UpdateProfile : BaseActivity(), HttpClient {
  
  lateinit var service: IProfile
  private var imageUri: Uri? = null
  lateinit var loadingDialog: LoadingDialog
  private var profile: ProfileDto? = null
  private var currentAvatar: String? = null
  private var encodedImage: String? = null
  private val permissionRequired = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_update_profile)
    
    initialView()
    initialService()
    initialData()
  }
  
  private fun initialView() {
//    getBackActionBar(header, getString(R.string.user_profile))
//    loadingDialog = LoadingDialog(this)
//    loadingDialog.createDialog()
//
//    saveChangeButton.setOnClickListener {
//      updateProfile()
//    }
//    avatarView.setOnClickListener {
//      askPermission()
//      selectImageFromGallery()
//    }
  }
  
  private fun initialService() {
    service = retrofit.create(IProfile::class.java)
  }
  
  private fun initialData() {
    getProfile()
  }
  
  private fun getProfile() {
    ProfileSingleton.instance.profile.observe(this, Observer {
      blindData(it)
    })
  }
  
  private fun askPermission() {
    if (!isAskPermissions(permissionRequired))
      ActivityCompat.requestPermissions(this, permissionRequired, 1)
  }
  
  private fun isAskPermissions(permissions: Array<String>): Boolean {
    for (permission in permissions)
      if (checkSelfPermissions(permission))
        return false
    return true
  }
  
  private fun checkSelfPermissions(permission: String): Boolean {
    return ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED
  }
  
  private fun selectImageFromGallery() {
    val intent = Intent()
    intent.type = "image/*"
    intent.action = Intent.ACTION_GET_CONTENT
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
  }
  
  private fun showLoadingDialog() {
    loadingDialog.showDialog()
  }
  
  private fun dismissLoadingDialog() {
    loadingDialog.dismiss()
  }
  
  private fun blindData(account: AccountDto?) {
    val profile = account?.profile
//    currentAvatar = profile?.avatar
//    editName.setText(profile?.fullname)
//    editEmail.setText(profile?.email)
//    editPhone.setText(account?.phonenumber)
//    Image(this).setAvatar(avatarView, profile?.avatar)
  }
  
  private fun updateProfileWithSingleTon(account: AccountDto?) {
    ProfileSingleton.instance.updateData(account)
  }
  
  private fun catchAccount(account : AccountDto?){
    if(account != null)
      CatchAccount(this).setData(account)
  }
  
  private fun showToastMessage(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }
  
  private fun updateProfile() {
    showLoadingDialog()
    val authorization = getAuthorization()
    
//    val fullname = editName.text.toString()
//    val email = editEmail.text.toString()
//    val phone = editPhone.text.toString()
//
    var updateProfile : UpdateProfileDto? = null
    
//    if (encodedImage != null)
//      updateProfile = UpdateProfileDto(phone, fullname, email, encodedImage)
//    else updateProfile = UpdateProfileDto(phone, fullname, email, null)
//
//    service.updateProfile(authorization, updateProfile)
//      .observeOn(AndroidSchedulers.mainThread())
//      .subscribeOn(Schedulers.io())
//      .subscribe({
//        val result = it.result
//        catchAccount(result)
//        showToastMessage("Update Profile Successful")
//        updateProfileWithSingleTon(result)
//        dismissLoadingDialog()
//      }, {
//        showToastMessage("Update Profile Failed")
//        dismissLoadingDialog()
//        it.printStackTrace()
//      })
  }
  
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
      val selectImageUri: Uri? = data?.data
      encodedImage = encodeImage(selectImageUri)
     // avatarView.setImageURI(selectImageUri)
    }
  }
  
  private fun encodeImage(image: Uri?): String? {
    if (image != null) {
      val path = getPath(image)
      val imageFile = File(path)
      
      var fileInputStream: FileInputStream? = null
      try {
        fileInputStream = FileInputStream(imageFile)
      } catch (e: FileNotFoundException) {
        e.printStackTrace()
      }
      val bitmap = BitmapFactory.decodeStream(fileInputStream)
      val byteArrayOutputStream = ByteArrayOutputStream()
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
      val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
      return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
    return null
  }
  
  
  private fun getPath(uri: Uri): String? {
    var path: String? = null
    try {
      var cursor = contentResolver
        .query(uri, null, null, null, null)
      cursor?.moveToFirst()
      var imageString = cursor?.getString(0)
      imageString = imageString?.substring(imageString.lastIndexOf(":") + 1)
      cursor?.close()
      cursor = contentResolver.query(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        null,
        MediaStore.Images.Media._ID + "= ?",
        arrayOf(imageString),
        null
      )
      cursor?.moveToFirst()
     // path = cursor?.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
      cursor?.close()
    } catch (ex: Exception) {
      ex.printStackTrace()
    }
    return path
  }
  companion object {
    private const val PICK_IMAGE = 1
  }
}
