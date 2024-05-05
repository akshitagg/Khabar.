package com.example.khabar_new.domain.usecases.news

import com.example.khabar_new.domain.model.Article
import com.example.khabar_new.domain.repository.NewsRepository

class DeleteArticle (
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article = article)
    }

}