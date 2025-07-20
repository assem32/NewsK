package com.example.myapplication.core.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.feature.boardingScreen.presentation.BoardingScreen
import com.example.myapplication.feature.details.DetailsView
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.feature.home.presentation.HomeView
import com.google.gson.Gson


@Composable
fun NavGraph(
    startDistination : String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDistination){
        composable (Route.onBoardingScreenNav){
            BoardingScreen(navController =  navController)
        }
        composable (Route.homeScreen){
            HomeView(navController = navController)
        }
        composable (Route.detailsScreen+"/{newsJson}",
                arguments = listOf(navArgument("newsJson") { type = NavType.StringType })){
                backStackEntry ->
            val json = backStackEntry.arguments?.getString("newsJson")
            val newsEntity = Gson().fromJson(json, NewsItemEntity::class.java)

            DetailsView(newsEntity)
        }
    }


}