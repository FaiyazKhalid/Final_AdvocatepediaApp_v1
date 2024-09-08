package com.advocatepedia.lite.ui.screens.today_screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.advocatepedia.lite.data.fakeUiFeaturedArticle
import com.advocatepedia.lite.ui.UiArticle
import com.advocatepedia.lite.ui.components.CustomAsyncImage
import com.advocatepedia.lite.ui.components.CustomCard
import com.advocatepedia.lite.ui.components.SectionHeading
import com.advocatepedia.lite.ui.theme.ViWiki2Theme
import org.w3c.dom.Text

import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button

import androidx.compose.material3.IconButton
import androidx.compose.ui.platform.LocalContext

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FeaturedArticleSection(
    featuredArticle: UiArticle,
    onArticleClicked: (UiArticle) -> Unit
)

{
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    var userMessage by remember { mutableStateOf(sharedPreferences.getString("user_message", "") ?: "") }

    Column {
            SectionHeading(text = "Wish Me")
            CustomCard(
              //  onClick = { onArticleClicked.invoke(featuredArticle) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    featuredArticle.wish?.let {
                        Text(text = it)
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    TextField(
                        value = userMessage,
                        onValueChange = { userMessage = it },
                        label = { Text("Add Your Contact Details. You can wish member directly to watsapp number") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString("user_message", userMessage)
                        editor.apply()

                        val phoneNumber = featuredArticle.num // Replace with the desired phone number
                        val message = "I wish you a very very Happy Birthday." // Replace with the desired message
                        val uri = Uri.parse("whatsapp://send?phone=$phoneNumber&text=$message\n" +
                                "\n" +
                                "$userMessage")
                        val shareIntent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(shareIntent)
                    }) {

                        Icon(
                            imageVector = Icons.Default.Whatsapp,
                            contentDescription = "Share on WhatsApp"
                        )
                    }
                }
            }
        }


    Column {
        SectionHeading(text = "Today's Featured Article")
        CustomCard(
            onClick = { onArticleClicked.invoke(featuredArticle) }
        ) {
            CustomAsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = featuredArticle.thumbnail?.sourceAndId,
                aspectRatio = 16 / 9f
            )
            Column(modifier = Modifier.padding(16.dp)) {
                featuredArticle.normalizedTitle?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
                featuredArticle.description?.let {
                    Text(text = it)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }


    Column {
        SectionHeading(text = "On This Day")
        CustomCard(
            //  onClick = { onArticleClicked.invoke(featuredArticle) }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                featuredArticle.nid?.let {
                    Text(text = it)
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = userMessage,
                    onValueChange = { userMessage = it },
                    label = { Text("Add Your Contact Details") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("user_message", userMessage)
                    editor.apply()

                    val shareIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Advocatepedia Feed: ${featuredArticle.nid}\n\n$userMessage")
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Share")
                }
            }
        }
    }



    Column {
        SectionHeading(text = "Latest Judgement")
        CustomCard(
            //  onClick = { onArticleClicked.invoke(featuredArticle) }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                featuredArticle.news?.let {
                    Text(text = it)
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = userMessage,
                    onValueChange = { userMessage = it },
                    label = { Text("Add Your Contact Details") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("user_message", userMessage)
                    editor.apply()

                    val shareIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Advocatepedia Feed: ${featuredArticle.news}\n\n$userMessage")
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Share")
                }
            }
        }
    }




}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun FeaturedArticleSectionPreview() {
    ViWiki2Theme {
        Surface {
            FeaturedArticleSection(
                featuredArticle = fakeUiFeaturedArticle,
                onArticleClicked = {})
        }
    }
}