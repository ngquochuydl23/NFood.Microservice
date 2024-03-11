package com.nsolution.nfood.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


interface HttpClient {
  
  val httpClient: OkHttpClient.Builder
    get() = OkHttpClient.Builder()
  
  val retrofit: Retrofit
    get() = retrofitBuilder("https://e607f49440d6.ngrok.io/nwork-api/")
  
  val goongRetrofit: Retrofit
    get() = retrofitBuilder("https://rsapi.goong.io/")
  
  private fun retrofitBuilder(baseUrl: String) : Retrofit{
    return Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
      .client(httpClient.build())
      .build()
  }
}