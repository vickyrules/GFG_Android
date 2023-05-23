package com.mine.gfgnews.network.service

import com.mine.gfgnews.network.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v1/api.json")
    suspend fun getNewsList(@Query("rss_url") rssUrl: String): NewsResponse
}