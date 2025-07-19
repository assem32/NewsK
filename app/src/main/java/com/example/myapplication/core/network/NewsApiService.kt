package com.example.myapplication.core.network

import com.example.myapplication.feature.home.data.model.NewModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("everything")
    suspend fun getEveryThing (@Query("q") q:String,@Query("from") from:String, @Query("sortBy")sorted :String, @Query("apiKey" )apiKey:String): NewModel
}