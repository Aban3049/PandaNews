package com.example.pandanews.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    https://newsapi.org/v2/
//    GET https://newsapi.org/v2/top-headlines?country=us&apiKey=bd8e84b4994a4a7eb542d3c9bb87f729

    @GET("top-headlines")

    suspend fun getNewsFromServer(
        @Query("country") country: String = "jp",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "bd8e84b4994a4a7eb542d3c9bb87f729"
    ): Response<NewsModel>

}