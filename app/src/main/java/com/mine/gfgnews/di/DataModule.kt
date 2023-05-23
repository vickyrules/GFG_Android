package com.mine.gfgnews.di

import com.mine.gfgnews.data.repository.NewsRepository
import com.mine.gfgnews.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun provideNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ):NewsRepository
}