package com.example.khabar_new.domain.usecases.news

import com.example.khabar_new.domain.model.Article
import com.example.khabar_new.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article = article)
    }

}