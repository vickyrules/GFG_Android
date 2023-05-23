package com.mine.gfgnews.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Enclosure(
    @SerialName("link")
    val link: String, // https://live-production.wcms.abc-cdn.net.au/ae7201807f5c4055d71e4b1be36cf338?impolicy=wcms_crop_resize&amp;cropH=1688&amp;cropW=3000&amp;xPos=0&amp;yPos=76&amp;width=862&amp;height=485
    @SerialName("thumbnail")
    val thumbnail: String, // https://live-production.wcms.abc-cdn.net.au/ae7201807f5c4055d71e4b1be36cf338?impolicy=wcms_crop_resize&amp;cropH=2010&amp;cropW=1507&amp;xPos=1002&amp;yPos=0&amp;width=862&amp;height=1149
    @SerialName("type")
    val type: String // image/jpeg
)