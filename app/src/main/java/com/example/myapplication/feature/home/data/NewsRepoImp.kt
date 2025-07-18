package com.example.myapplication.feature.home.data

import com.example.myapplication.feature.home.data.model.dummyNewsList
import com.example.myapplication.feature.home.data.model.toNewsItem
import com.example.myapplication.feature.home.data.remote.RemoteDataSource
import com.example.myapplication.feature.home.domain.INewRepo
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import javax.inject.Inject

class NewsRepoImp @Inject constructor(val remoteDataSource: RemoteDataSource) : INewRepo {
    override suspend fun getNews(): List<NewsItemEntity> {
        val response = remoteDataSource.getNewsData(q = "q", sorted = "publishedAt", date = "2025-06-18")
        val newsItemList: List<NewsItemEntity> = response.articles.map { it.toNewsItem() }
        return newsItemList
    }
}