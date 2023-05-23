package com.mine.gfgnews.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mine.gfgnews.network.service.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

const val BASE_URL = "https://api.rss2json.com/"

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/Json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideMewsApiServide(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }
}