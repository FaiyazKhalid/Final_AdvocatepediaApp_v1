package com.advocatepedia.lite.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.advocatepedia.lite.ui.theme.ViWiki2Theme


@Composable
fun CustomAsyncImage(modifier: Modifier = Modifier, model: Any?, aspectRatio: Float) {
    CustomAsyncImage(modifier = modifier.aspectRatio(aspectRatio), model = model)
}

@Composable
fun CustomAsyncImage(modifier: Modifier = Modifier, model: Any?) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = model,
        contentScale = ContentScale.FillWidth,
        contentDescription = null,
        loading = {
            LoadingSkeleton(modifier=Modifier.fillMaxSize(),startColor = MaterialTheme.colorScheme.onBackground)
        },
        error = {
            Surface(color = MaterialTheme.colorScheme.onBackground) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Error loading image"
                    )
                }
            }
        })
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun CustomAsyncImagePreview() {
    ViWiki2Theme {
        Surface {
            CustomAsyncImage(modifier = Modifier.fillMaxWidth(), model = null)
        }
    }
}