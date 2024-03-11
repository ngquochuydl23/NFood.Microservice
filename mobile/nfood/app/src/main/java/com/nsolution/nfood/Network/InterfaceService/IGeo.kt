package com.nsolution.nfood.Network.InterfaceService

import com.nsolution.nfood.Models.RequestGeoCodingDto
import com.nsolution.nfood.Models.ResultGeoCodingDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface IGeo {
  @GET("Geocode")
  fun searchGeoCoding(
    @Query("api_key") apiKey: String?, @Query("address") requestGeoCoding: RequestGeoCodingDto
  ): Observable<ResultGeoCodingDto>
}