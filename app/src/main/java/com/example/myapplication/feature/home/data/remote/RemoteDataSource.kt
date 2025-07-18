package com.example.myapplication.feature.home.data.remote

import com.example.myapplication.core.network.NewsApiService
import com.example.myapplication.feature.home.data.model.NewModel
import java.util.Date
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val newsApiService: NewsApiService){
    suspend fun getNewsData(q:String,date:String,sorted:String): NewModel {
        return newsApiService.getEveryThing(q = q, from = date, sorted = sorted,  apiKey = "0e76c948d8f54f02b7ddfe392a2269d8")
    }
}