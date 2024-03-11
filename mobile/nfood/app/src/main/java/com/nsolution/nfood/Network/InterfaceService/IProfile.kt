package com.nsolution.nfood.Network.InterfaceService

import com.nsolution.nfood.Models.AccountDto
import com.nsolution.nfood.Models.ResultAction
import com.nsolution.nfood.Models.UpdateProfileDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PUT


interface IProfile {
  
  @GET("Profile")
  fun getProfile(@Header("Authorization") token: String)
          : Observable<ResultAction<AccountDto>>
  
  @PUT("Profile")
  fun updateProfile(@Header("Authorization") token: String, @Body newProfile: UpdateProfileDto)
          : Observable<ResultAction<AccountDto>>
}