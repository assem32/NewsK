package com.example.myapplication.feature.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.feature.home.presentation.HomeViewModel

@Composable
fun NewsList(newsList:List<NewsItemEntity>, navController: NavController, viewModel: HomeViewModel = hiltViewModel(),){

    var searchText by remember {
        mutableStateOf("")
    }
    val state = viewModel.filteredListLiveData.observeAsState().value
    Column {

        OutlinedTextField(

            value = searchText,
            label = { Text(text = "Search") },
            onValueChange = {
                searchText=it
                viewModel.searchList(newList = newsList, query = searchText)
            }
            ,modifier = Modifier
                .fillMaxWidth()
//                .weight(1f)
        )
        when(state ) {
            is BaseStates.Success -> {
                LazyColumn {
                    itemsIndexed(state.data) { index: Int, item: NewsItemEntity ->
                        NewsItem(item, navController)
                    }
                }
            }
            is BaseStates.Error -> {
                Text(text = state.message)
            }
            is BaseStates.Loading->{
                CircularProgressIndicator()
            }
            null-> ""
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun NewsLisPreview() {
//    MyApplicationTheme {
//        NewsList()
//    }
//}