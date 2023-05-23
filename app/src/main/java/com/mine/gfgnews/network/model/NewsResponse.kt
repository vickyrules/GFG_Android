package com.mine.gfgnews.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("feed")
    val feed: Feed,
    @SerialName("items")
    val items: List<Item>,
    @SerialName("status")
    val status: String // ok
)