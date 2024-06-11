package com.example.pandanews.repo

import com.example.pandanews.network.ApiBuilder
import com.example.pandanews.network.NewsModel
import retrofit2.Response


class Repo {


    suspend fun newProvider(
        country: String,
    ): Response<NewsModel> {
        return ApiBuilder.apiProvider().getNewsFromServer(country = country)
    }


}