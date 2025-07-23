package com.example.myapplication.feature.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.feature.home.data.local.DAO
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(val dao: DAO):ViewModel() {

     fun saveNews(newsItemEntity: NewsItemEntity){
        viewModelScope.launch {
            dao.insertNewsItem(newsItemEntity)

        }
    }
    fun getSavedNews(){
        viewModelScope.launch {
            val newsList = dao.getAllNews()
            Log.d("local" , ""+newsList)
        }
    }


}