package com.advocatepedia.lite.adapters

import com.advocatepedia.lite.data.database.entities.DatabaseArticle
import com.advocatepedia.lite.data.database.entities.DatabaseDayImage
import com.advocatepedia.lite.data.database.entities.DatabaseImage
import com.advocatepedia.lite.data.database.entities.DatabaseOnThisDay
import com.advocatepedia.lite.ui.UiArticle
import com.advocatepedia.lite.ui.UiDayArticle
import com.advocatepedia.lite.ui.UiDayImage
import com.advocatepedia.lite.ui.UiOnThisDay

fun DatabaseArticle.toUiArticle(
    thumbnail: DatabaseImage?,
    fullSizeImage: DatabaseImage?,
) = UiArticle(
    id = articleId,
    normalizedTitle = normalizedTitle,
    description = description,
    extract = extract,
    thumbnail = thumbnail,
    fullSizeImage = fullSizeImage,
    news = news,
    nid = nid,
    wish = wish,
    num = num,

)

fun DatabaseArticle.toUiDayArticle(
    thumbnail: DatabaseImage?,
) = UiDayArticle(
    id = articleId,
    views = views,
    normalizedTitle = normalizedTitle,
    description = description,
    extract = extract,
    thumbnail = thumbnail,
    news = news,
    nid = nid,
    wish = wish,
    num = num,

)

fun DatabaseDayImage.toUiDayImage(
    thumbnail: DatabaseImage,
    fullSizeImage: DatabaseImage,
) = UiDayImage(
    idAndTitle = titleAndId,
    thumbnail = thumbnail,
    fullSizeImage = fullSizeImage,
    description = description,
)

fun DatabaseArticle.toUiFeaturedArticle(
    thumbnail: DatabaseImage?,
    fullSizeImage: DatabaseImage?,
) = UiArticle(
    id = articleId,
    thumbnail = thumbnail,
    fullSizeImage = fullSizeImage,
    normalizedTitle = normalizedTitle,
    description = description,
    extract = extract,
    news = news,
    nid = nid,
    wish = wish,
    num = num,
)


fun DatabaseOnThisDay.toUiOnThisDay(yearArticles: List<UiArticle>?): UiOnThisDay {
    return UiOnThisDay(
        text = this.text,
        year = this.year,
        articles = yearArticles

    )
}







