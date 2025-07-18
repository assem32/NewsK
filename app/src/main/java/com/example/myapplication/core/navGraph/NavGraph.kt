package com.example.myapplication.core.navGraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.feature.boardingScreen.presentation.BoardingScreen
import com.example.myapplication.feature.boardingScreen.presentation.component.OnBoardingView
import com.example.myapplication.feature.home.presentation.HomeView


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
            HomeView()
        }
    }


}