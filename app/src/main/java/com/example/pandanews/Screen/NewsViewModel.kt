package com.example.pandanews.Screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pandanews.network.NewsModel
import com.example.pandanews.repo.Repo

import kotlinx.coroutines.launch

class NewsViewModel() : ViewModel() {

    var res = mutableStateOf<NewsModel?>(null)

    init {
        viewModelScope.launch {
           res.value = getNews(Repo())
        }
    }

    suspend fun getNews(repo: Repo): NewsModel? {

        return repo.newProvider().body()

    }


}