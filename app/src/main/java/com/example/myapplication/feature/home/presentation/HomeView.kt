package com.example.myapplication.feature.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.home.presentation.component.NewsList


@Composable
fun HomeView( homeViewModel: HomeViewModel = hiltViewModel() ){
    LaunchedEffect(Unit) {
        homeViewModel.getNews()
    }
    val state = homeViewModel.newsListLiveData.observeAsState().value
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when(state){
            is BaseStates.Loading ->{
                CircularProgressIndicator(color = colorResource(R.color.teal_700))
            }
            is BaseStates.Success -> {
                val data = state.data
                NewsList(data)
            }

            is BaseStates.Error -> {
                val message = state.message
                Text(text = message)
            }
             null -> ""
        }

    }
}