package com.advocatepedia.lite.ui.screens.today_screen

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.advocatepedia.lite.data.fakeDayData
import com.advocatepedia.lite.data.repository.Repository
import com.advocatepedia.lite.ui.UiDayData
import com.advocatepedia.lite.ui.theme.ViWiki2Theme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination
@RootNavGraph(start = true)
fun TodayScreen(
    dayData: UiDayData?,
    dayDataStatus: Repository.Status?,
    onArticleClicked: (articleId: Int) -> Unit
) {
    LazyColumn(state = rememberLazyListState()) {
        if (dayData == null) return@LazyColumn
        dayData.image?.let {
            item {
                DayImageSection(it)
            }
        }

        dayData.featuredArticle?.let {
            item {
                FeaturedArticleSection(featuredArticle = it, onArticleClicked = {
                    onArticleClicked.invoke(it.id)
                })
            }
        }

/*
        dayData.mostReadArticles?.let {
            item {
                MostReadArticlesSection(
                    mostReadArticles = it,
                    onArticleClicked = {
                        onArticleClicked.invoke(it.id)
                    }
                )
            }
        }
*/
/*
*         dayData.onThisDay?.let { yearContent ->
            item {
                SectionHeading(text = "On this day")
            }
            items(yearContent) { onThisDay ->
                OnThisDayYearSection(onThisDay, onArticleClicked)
            }
        }
*/


    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun TodayScreenPreview() {
    ViWiki2Theme {
        Surface {
            TodayScreen(
                dayData = fakeDayData,
                dayDataStatus = Repository.Status.Success,
                onArticleClicked = {})
        }

    }
}