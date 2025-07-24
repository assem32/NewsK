package com.example.myapplication.feature.details

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.core.Dimens
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.feature.home.presentation.HomeViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import javax.inject.Inject

@Composable
fun DetailsView (newsItemEntity: NewsItemEntity, detailsViewModel :DetailsViewModel = hiltViewModel(),navController: NavController){

    Column(modifier = Modifier.padding(Dimens.smallPadding)) {
        Row (modifier = Modifier.fillMaxWidth()){
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_back_arrow),
                    contentDescription = "Back Icon"
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = {
                    detailsViewModel.saveNews(newsItemEntity)
                }
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = "Save")
            }
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector =   Icons.Default.Share,
                    contentDescription = "Share"
                )
            }
            IconButton(
                onClick = {
                    val encodedUrl = Uri.encode(newsItemEntity.url)
                    navController.navigate("webview?url=$encodedUrl")
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_network),
                    contentDescription = "Open in Browser"
                )
            }
        }
        Spacer(modifier = Modifier.height(Dimens.smallPadding))
        AsyncImage(
            model = newsItemEntity.imageUrl,
            contentDescription = "News Image",
            modifier = Modifier.fillMaxWidth().size(400.dp).clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Dimens.smallPadding))
        Text(text = newsItemEntity.title, style = TextStyle(color = colorResource(R.color.display_small), fontSize = MaterialTheme.typography.titleLarge.fontSize))
        Text(text = newsItemEntity.title , style = TextStyle(color = colorResource(R.color.text_medium), fontSize = MaterialTheme.typography.bodyMedium.fontSize))
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DetailsViewPreview() {
//    MyApplicationTheme  {
//        DetailsView(NewsItemEntity(
//            source =  "CNN",
//            title = "Global Markets Rally as Inflation Slows Down",
//            publishedAt = "2025-07-17T08:30:00Z",
//            imageUrl = "",
//            url = ""
//        ), navController = )
//    }
//}