package com.example.myapplication.feature.saved.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.details.DetailsViewModel
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.feature.home.presentation.component.NewsItem

@Composable
fun SavedView( detailsViewModel : DetailsViewModel = hiltViewModel(),navController: NavController){
    LaunchedEffect(Unit) {
        detailsViewModel.getSavedNews()
    }
    val state = detailsViewModel.savedList.observeAsState().value
    when(state){
        is BaseStates.Success->{
            val data = state.data
            Column {
                LazyColumn {
                    itemsIndexed(data){
                            index :Int , item: NewsItemEntity -> NewsItem(item,navController)
                    }
                }
            }
        }
        is BaseStates.Loading->{
            CircularProgressIndicator()
        }
        is BaseStates.Error->{
            Text(state.message)
        }
        null-> ""
    }

}