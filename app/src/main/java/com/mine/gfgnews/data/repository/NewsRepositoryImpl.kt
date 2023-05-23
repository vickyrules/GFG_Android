package com.mine.gfgnews.data.repository

import com.mine.gfgnews.network.model.Item
import com.mine.gfgnews.network.service.NewsApiService
import javax.inject.Inject

val rssUrl = "http://www.abc.net.au/news/feed/51120/rss.xml"

class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsRepository {
    override suspend fun getNewsList(): List<Item> {
        val response = newsApiService.getNewsList(rssUrl = rssUrl)
        return response.items
    }
}