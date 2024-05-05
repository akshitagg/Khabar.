package com.example.khabar_new.di

import android.app.Application
import androidx.room.Room
import com.example.khabar_new.data.local.NewsDao
import com.example.khabar_new.data.local.NewsDatabase
import com.example.khabar_new.data.local.NewsTypeConverter
import com.example.khabar_new.data.manager.UserImplementation
import com.example.khabar_new.data.remote.NewsApi
import com.example.khabar_new.data.repository.NewsRepositoryImpl
import com.example.khabar_new.domain.manager.LocalUserManager
import com.example.khabar_new.domain.repository.NewsRepository
import com.example.khabar_new.domain.usecases.app_entry.AppEntryUseCases
import com.example.khabar_new.domain.usecases.app_entry.ReadAppEntry
import com.example.khabar_new.domain.usecases.app_entry.SaveAppEntry
import com.example.khabar_new.domain.usecases.news.DeleteArticle
import com.example.khabar_new.domain.usecases.news.SelectArticle
import com.example.khabar_new.domain.usecases.news.GetArticles
import com.example.khabar_new.domain.usecases.news.GetNews
import com.example.khabar_new.domain.usecases.news.NewsUseCases
import com.loc.newsapp.domain.usecases.news.SearchNews
import com.example.khabar_new.domain.usecases.news.SelectArticles
import com.example.khabar_new.domain.usecases.news.UpsertArticle
import com.example.khabar_new.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = UserImplementation(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            getArticles = GetArticles(newsDao),
            getArticle = SelectArticle(newsRepository)
        )
    }

}