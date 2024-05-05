package com.example.khabar_new.data.remote.dto

import com.example.khabar_new.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)