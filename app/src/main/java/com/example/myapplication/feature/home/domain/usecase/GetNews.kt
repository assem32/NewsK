package com.example.myapplication.feature.home.domain.usecase

import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.home.domain.INewRepo
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import javax.inject.Inject

class GetNews @Inject constructor(val iNewRepo: INewRepo){
    suspend fun invoke ():BaseStates<List<NewsItemEntity>>{
        return iNewRepo.getNews()
    }
}