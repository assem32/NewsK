package com.example.myapplication.feature.home.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsTable")
data class NewsItemEntity(
    val title: String,
    val source: String,
    val imageUrl: String,
    val publishedAt:String,
    @PrimaryKey
    val url:String

)
