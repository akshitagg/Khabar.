package com.example.khabar_new.domain.usecases.news

import com.loc.newsapp.domain.usecases.news.SearchNews

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles,
    val getArticles: GetArticles,
    val getArticle: SelectArticle
) {

}
