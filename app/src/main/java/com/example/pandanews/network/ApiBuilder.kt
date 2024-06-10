package com.example.pandanews.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiBuilder {

    fun apiProvider() =
        Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)

}