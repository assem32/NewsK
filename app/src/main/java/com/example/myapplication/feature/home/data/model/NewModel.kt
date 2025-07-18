package com.example.myapplication.feature.home.data.model

data class NewModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)