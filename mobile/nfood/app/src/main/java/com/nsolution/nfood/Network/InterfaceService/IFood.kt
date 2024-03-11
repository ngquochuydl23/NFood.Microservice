package com.nsolution.nfood.Network.InterfaceService

import com.nsolution.nfood.Models.ResultAction
import com.nsolution.nfood.Models.HomeContentDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface IFood {
  
  @GET("Food/{id}")
  fun getDetailFood(
    @Header("Authorization") token: String?,
    @Path("id") foodId: Int?
  ): Observable<ResultAction<HomeContentDto>>
  
  @POST("Food/{id}/AddToFavourite")
  fun addToFavourite(
    @Header("Authorization") token: String?,
    @Path("id") foodId: Int?
  ): Observable<ResultAction<HomeContentDto>>
  
  @POST("Food/{id}/RemoveFromFavourite")
  fun removeFromFavourite(
    @Header("Authorization") token: String?,
    @Path("id") foodId: Int?
  ): Observable<ResultAction<HomeContentDto>>
  
}