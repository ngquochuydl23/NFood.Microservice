package com.nsolution.nfood.https.api

import com.nsolution.nfood.Models.LocationDto
import com.nsolution.nfood.Models.ResultAction
import com.nsolution.nfood.Models.HomeContentDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface IHome {
  @POST("Home/GetHomeContent")
  fun getHomeContent(
    @Header("Authorization") token: String?,
    @Body location: LocationDto?
  ): Observable<ResultAction<HomeContentDto>>
}