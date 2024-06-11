package com.example.pandanews.navGraph


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pandanews.Screen.HomeApp
import com.example.pandanews.Screen.NewsDetailScreen
import com.example.pandanews.Screen.NewsViewModel
import com.example.pandanews.network.NewsModel
import com.google.gson.Gson

@Composable


fun Navigation() {

    val navController = rememberNavController()
    val viewModel: NewsViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeApp(viewModel = viewModel, navHostController = navController)
        }
        composable("newsDetail/{article}") { backStackEntry ->
            val articleJson = backStackEntry.arguments?.getString("article")
            val selectedArticle = Gson().fromJson(articleJson, NewsModel.Article::class.java) // Parse JSON back into article object
            NewsDetailScreen(selectedArticle) // Pass parsed article object
        }
        // ... other destinations
    }
}









