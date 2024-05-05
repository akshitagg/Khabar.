package com.example.khabar_new.domain.usecases.news

import com.example.khabar_new.data.local.NewsDao
import com.example.khabar_new.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}