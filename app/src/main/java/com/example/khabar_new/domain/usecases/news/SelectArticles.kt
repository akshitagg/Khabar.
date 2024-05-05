package com.example.khabar_new.domain.usecases.news

import com.example.khabar_new.domain.model.Article
import com.example.khabar_new.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}