package com.advocatepedia.lite.data

import com.advocatepedia.lite.data.database.entities.DatabaseImage
import com.advocatepedia.lite.ui.UiArticle
import com.advocatepedia.lite.ui.UiDayArticle
import com.advocatepedia.lite.ui.UiDayData
import com.advocatepedia.lite.ui.UiDayImage

const val DummyImageUrl =
    "https://upload.wikimedia.org/wikipedia/commons/c/c6/Golden-eyed_tree_frog_%28Agalychnis_annae%29.jpg"
val fakeDatabaseImage = DatabaseImage(sourceAndId = DummyImageUrl, width = 300, height = 300)
val fakeUiDayImage = UiDayImage(
    idAndTitle = "A frog",
    thumbnail = fakeDatabaseImage,
    fullSizeImage = fakeDatabaseImage,
    description = "Goes boing and ribbit",
)
val fakeUiFeaturedArticle = UiArticle(
    id = 1000,
    thumbnail = fakeDatabaseImage,
    fullSizeImage = fakeDatabaseImage,
    normalizedTitle = "Foo of the bar",
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.",
    extract = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    news = "Hi i am news",
    nid = "0",
    wish = "Happy Birthday",
    num = "num",
)
val fakeArticles = listOf(
    UiDayArticle(
        id = 0,
        views = 300_000,
        normalizedTitle = "Short",
        description = "Ut enim ad.",
        extract = "Ut enim ad minim veniam.",
        thumbnail = fakeDatabaseImage,
        news = "Hi i am news",
        nid = "0",
        wish = "Happy Birthday",
        num = "num",
    )
) + List(10) {
    UiDayArticle(
        id = 100 * it,
        views = 400_000,
        normalizedTitle = "Foo of the bar",
        description = "Ut enim ad.",
        extract = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        thumbnail = fakeDatabaseImage,
        news= "Hi i am news",
        nid = "0",
        wish = "Happy Birthday",
        num = "num",
    )
}

val fakeDayData = UiDayData(
    featuredArticle = fakeUiFeaturedArticle,
    mostReadArticles = fakeArticles,
    image = null,
    onThisDay = null,
)

