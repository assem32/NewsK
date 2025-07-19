package com.example.myapplication.feature.home.domain

import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity

interface INewRepo {
    suspend fun getNews():BaseStates<List<NewsItemEntity>>
}