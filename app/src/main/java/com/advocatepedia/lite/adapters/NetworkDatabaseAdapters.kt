package com.advocatepedia.lite.adapters

import com.advocatepedia.lite.data.database.entities.DatabaseArticle
import com.advocatepedia.lite.data.database.entities.DatabaseImage
import com.advocatepedia.lite.data.database.entities.DatabaseOnThisDay
import com.advocatepedia.lite.data.network.NetworkImage
import com.advocatepedia.lite.data.network.day.NetworkArticle
import com.advocatepedia.lite.data.network.day.NetworkFeaturedArticle
import com.advocatepedia.lite.data.network.day.NetworkOnThisDay

fun NetworkFeaturedArticle.toDatabaseModel() =
    DatabaseArticle(
        articleId = this.pageId,
        originalImageId = this.originalImage?.source,
        thumbnailId = this.originalImage?.source,
        description = this.description,
        extract = this.extract,
        normalizedTitle = this.normalizedTitle,
        views = null,
        isFeatured = true,
        news = this.news,
        nid = this.nid,
        wish = this.wish,
        num = this.num,
    )


fun NetworkImage.toDatabaseModel() = DatabaseImage(
    sourceAndId = this.source,
    width = this.width,
    height = this.height
)

fun NetworkArticle.toDatabaseModel(
    onThisDayYear: Int? = null,
    isMostRead: Boolean = false,
    isFeatured: Boolean = false,
): DatabaseArticle {
    return DatabaseArticle(
        articleId = this.pageId,
        views = this.views,
        normalizedTitle = this.normalizedTitle,
        description = this.description ?: "",
        extract = this.extract,
        thumbnailId = this.thumbnail?.source,
        originalImageId = this.thumbnail?.source,
        onThisDayYear = onThisDayYear,
        isMostRead = isMostRead,
        isFeatured = isFeatured,
        news = this.news,
        nid = this.nid,
        wish = this.wish,
        num = this.num,

    )
}

fun NetworkOnThisDay.toDatabaseModel(): DatabaseOnThisDay {
    return DatabaseOnThisDay(
        text = this.text,
        year = this.year,
    )
}