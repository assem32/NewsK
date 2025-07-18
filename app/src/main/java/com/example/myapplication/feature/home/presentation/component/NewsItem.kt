package com.example.myapplication.feature.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.core.Dimies
import com.example.myapplication.feature.home.data.model.Article
import com.example.myapplication.feature.home.data.model.Source
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun NewsItem(artcalModel: NewsItemEntity) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.size(Dimies.articleCardSize),
            model = artcalModel.imageUrl,
            contentDescription = "image"
        )
        Column(
            modifier = Modifier.height(Dimies.articleCardSize),
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = artcalModel.title,style = MaterialTheme.typography.bodyMedium , maxLines = 2, overflow = TextOverflow.Ellipsis, color = colorResource(R.color.display_small))
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = artcalModel.source,style = MaterialTheme.typography.labelSmall, color = colorResource(R.color.display_small))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = "time icon",
                    tint = colorResource(id = R.color.body)
                )
                Text(text = artcalModel.publishedAt, style = MaterialTheme.typography.labelSmall, color = colorResource(R.color.display_small))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsItemPreview() {
    MyApplicationTheme {
        NewsItem(
            NewsItemEntity(
                source =  "CNN",
                title = "Global Markets Rally as Inflation Slows Down",
                publishedAt = "2025-07-17T08:30:00Z",
                imageUrl = ""
            ),
        )
    }
}