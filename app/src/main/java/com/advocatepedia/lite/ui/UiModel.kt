package com.advocatepedia.lite.ui

import com.advocatepedia.lite.data.database.entities.DatabaseImage


data class UiDayData(
    val featuredArticle: UiArticle?,
    val mostReadArticles: List<UiDayArticle>?,
    val image: UiDayImage?,
    val onThisDay: List<UiOnThisDay>?,
)


data class UiDayArticle(
    val id: Int,
    val views: Int?,
    val normalizedTitle: String?,
    val news: String?,
    val nid: String?,
    val wish: String?,
    val num: String?,
    val description: String?,
    val extract: String?,
    val thumbnail: DatabaseImage?,
)

data class UiDayImage(
    val idAndTitle: String,
    val thumbnail: DatabaseImage,
    val fullSizeImage: DatabaseImage,
    val description: String,
)

data class UiArticle(
    val id: Int,
    val nid: String?,
    val thumbnail: DatabaseImage?,
    val fullSizeImage: DatabaseImage?,
    val normalizedTitle: String?,
    val news: String?,
    val wish: String?,
    val num: String?,
    val description: String?,
    val extract: String?,
)
data class UiArticles(
    val id: Int,
    val nid: String?,
    val thumbnail: DatabaseImage?,
    val fullSizeImage: DatabaseImage?,
    val normalizedTitle: String?,
    val news: String?,
    val wish: String?,
    val num: String?,
    val description: String?,
    val extract: String?,
)
data class UiOnThisDay(
    val text: String,
    val year: Int,
    val articles: List<UiArticle>?
)

