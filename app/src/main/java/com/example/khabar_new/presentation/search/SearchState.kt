package com.example.khabar_new.presentation.search

import androidx.paging.PagingData
import com.example.khabar_new.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
){

}