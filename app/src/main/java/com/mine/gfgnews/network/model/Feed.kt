package com.mine.gfgnews.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feed(
    @SerialName("author")
    val author: String,
    @SerialName("description")
    val description: String,
    @SerialName("image")
    val image: String, // https://live-production.wcms.abc-cdn.net.au/6f61ef606af0bbbcbdaa7c6173a677e2?impolicy=wcms_crop_resize&amp;cropH=144&amp;cropW=144&amp;xPos=0&amp;yPos=0&amp;width=862&amp;height=862
    @SerialName("link")
    val link: String, // https://www.abc.net.au/news/justin/
    @SerialName("title")
    val title: String, // Just In
    @SerialName("url")
    val url: String // http://www.abc.net.au/news/feed/51120/rss.xml
)