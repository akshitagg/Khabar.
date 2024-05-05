package com.example.khabar_new.presentation.bookmark

import com.example.khabar_new.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
