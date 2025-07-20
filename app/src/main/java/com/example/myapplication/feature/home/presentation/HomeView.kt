package com.example.myapplication.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.home.presentation.component.NewsList


@Composable
fun HomeView( homeViewModel: HomeViewModel = hiltViewModel() ){

    LaunchedEffect(Unit) {
        homeViewModel.getNews()
    }
    Column {
        NewsList(homeViewModel = homeViewModel)
    }
}