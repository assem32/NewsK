package com.example.myapplication.feature.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.feature.home.presentation.HomeViewModel

@Composable
fun NewsList(homeViewModel: HomeViewModel){
    val list = homeViewModel.newsListLiveData.observeAsState(emptyList())
    Column {
        LazyColumn {
            itemsIndexed(list.value){
                index :Int , item: NewsItemEntity ->
                NewsItem(item)
            }
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