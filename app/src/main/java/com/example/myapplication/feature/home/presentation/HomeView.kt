package com.example.myapplication.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.feature.home.domain.usecase.GetNews
import com.example.myapplication.feature.home.presentation.component.NewsList
import javax.inject.Inject


@Composable
fun HomeView( homeViewModel: HomeViewModel = hiltViewModel() ){

    LaunchedEffect(Unit) {
        homeViewModel.getNews()
    }
    Column {
        NewsList(homeViewModel = homeViewModel)
    }
}