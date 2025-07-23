package com.example.myapplication.feature.home.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity

@Dao
interface DAO {
    @Query("Select * from newsTable")
    suspend fun getAllNews():List<NewsItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsItem(newsItemEntity: NewsItemEntity)
}