package com.example.myapplication.feature.home.presentation.component

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.core.Dimens
import com.example.myapplication.core.navGraph.Route
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.gson.Gson

@Composable
fun NewsItem(artcalModel: NewsItemEntity, navController:NavController) {
    Surface(onClick = {

        val json = Uri.encode(Gson().toJson(artcalModel))
        navController.navigate(Route.detailsScreen+"/"+json)
    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.smallPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(Dimens.articleCardSize)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                model = artcalModel.imageUrl,
                contentDescription = "image"
            )
            Spacer(Modifier.width(10.dp))
            Column(
                modifier = Modifier.height(Dimens.articleCardSize),
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = artcalModel.title,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(R.color.display_small)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = artcalModel.source,
                        style = MaterialTheme.typography.labelSmall,
                        color = colorResource(R.color.display_small)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_time),
                        contentDescription = "time icon",
                        tint = colorResource(id = R.color.body)
                    )
                    Text(
                        text = artcalModel.publishedAt,
                        style = MaterialTheme.typography.labelSmall,
                        color = colorResource(R.color.display_small)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsItemPreview() {
    MyApplicationTheme {
        val navController = rememberNavController()
        NewsItem(
            NewsItemEntity(
                source =  "CNN",
                title = "Global Markets Rally as Inflation Slows Down",
                publishedAt = "2025-07-17T08:30:00Z",
                imageUrl = "",
                url = ""

            ),
            navController = navController
        )
    }
}