package com.nsolution.nfood.https.api

import com.nsolution.nfood.Models.ResultAction
import com.nsolution.nfood.Models.HomeContentDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface IRestaurant {
  
  @GET("Restaurant/{id}")
  fun getRestaurant(
    @Header("Authorization") token: String,
    @Path("id") foodId: Int
  ): Observable<ResultAction<HomeContentDto>>
  
  @GET("Restaurant/{id}/Detail")
  fun getDetailRestaurant(
    @Header("Authorization") token: String,
    @Path("id") foodId: Int
  ): Observable<ResultAction<HomeContentDto>>
  
  @GET("Restaurant/{id}/Search")
  fun searchInRestaurant(
    @Header("Authorization") token: String,
    @Path("id") foodId: Int
  ): Observable<ResultAction<HomeContentDto>>
}