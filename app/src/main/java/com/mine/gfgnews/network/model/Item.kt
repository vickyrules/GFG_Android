package com.mine.gfgnews.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("author")
    val author: String,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("content")
    val content: String, // Controversial Dragons forward Jack de Belin will assume the St George Illawarra captaincy for this week's clash against the Dolphins. 
    @SerialName("description")
    val description: String, // Controversial Dragons forward Jack de Belin will assume the St George Illawarra captaincy for this week's clash against the Dolphins. 
    @SerialName("enclosure")
    val enclosure: Enclosure,
    @SerialName("guid")
    val guid: String, // https://www.abc.net.au/news/2023-05-23/jack-de-belin-named-to-captain-st-george-illawarra-in-round-13-c/102383544
    @SerialName("link")
    val link: String, // https://www.abc.net.au/news/2023-05-23/jack-de-belin-named-to-captain-st-george-illawarra-in-round-13-c/102383544
    @SerialName("pubDate")
    val pubDate: String, // 2023-05-23 07:49:13
    @SerialName("thumbnail")
    val thumbnail: String, // https://live-production.wcms.abc-cdn.net.au/ae7201807f5c4055d71e4b1be36cf338?impolicy=wcms_crop_resize&amp;cropH=2010&amp;cropW=1507&amp;xPos=1002&amp;yPos=0&amp;width=862&amp;height=1149
    @SerialName("title")
    val title: String // Jack de Belin named as St George Illawarra captain for Round 13 NRL clash with the Dolphins
)