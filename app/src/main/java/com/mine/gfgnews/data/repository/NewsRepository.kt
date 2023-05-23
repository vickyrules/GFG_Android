package com.mine.gfgnews.data.repository

import com.mine.gfgnews.network.model.Item

interface NewsRepository {
    suspend fun  getNewsList(): List<Item>
}