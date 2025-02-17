package com.advocatepedia.lite.ui.screens.today_screen.most_read_articles_section

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.advocatepedia.lite.data.fakeArticles
import com.advocatepedia.lite.ui.UiDayArticle
import com.advocatepedia.lite.ui.components.CustomAsyncImage
import com.advocatepedia.lite.ui.components.CustomCard
import com.advocatepedia.lite.ui.theme.ViWiki2Theme

private val CardTextHorizontalPadding = 16.dp

@Composable
internal fun ArticleSmallCard(
    modifier: Modifier = Modifier,
    article: UiDayArticle,
    index: Int,
    onClick: () -> Unit,
) {
    CustomCard(
        modifier = modifier.aspectRatio(9 / 4f), onClick = onClick
    ) {
        Row(modifier = Modifier.weight(1f)) {
            CustomAsyncImage(model = article.thumbnail?.sourceAndId, aspectRatio = 3 / 4f)
            Column(modifier = Modifier.padding(top = 8.dp)) {
                article.normalizedTitle?.let {
                    Text(
                        modifier = Modifier.padding(horizontal = CardTextHorizontalPadding),
                        text = it,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
                article.description?.let {
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = CardTextHorizontalPadding, vertical = 4.dp),
                        text = it,
                        maxLines = 3,
                    )
                }
                article.views?.let {
                    ViewsIndicator(
                        modifier = Modifier.padding(
                            horizontal = CardTextHorizontalPadding,
                            vertical = 2.dp
                        ),
                        views = it,
                        index = index
                    )
                }
            }
        }

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun ArticleSmallCardPreview() {
    ViWiki2Theme {
        Surface(modifier = Modifier.padding(16.dp)) {
            ArticleSmallCard(article = fakeArticles.first(), index = 0, onClick = {})
        }
    }
}