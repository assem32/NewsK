package com.example.myapplication.feature.boardingScreen.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import com.example.myapplication.feature.boardingScreen.domain.entity.OnBoardingEntity
import com.example.myapplication.feature.boardingScreen.domain.entity.pages
import com.example.myapplication.core.Dimies
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun OnBoardingItem(
    modifier: Modifier = Modifier,
    onBoardingEntity: OnBoardingEntity
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = onBoardingEntity.image),
            contentDescription = "Boarding Image",

            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(Dimies.smallPadding))
        Text(
            text = onBoardingEntity.title,
            style = TextStyle(fontSize = 10.sp, color = colorResource(R.color.display_small)),
            modifier = Modifier.padding(horizontal = Dimies.smallPadding)
        )
        Text(
            text = onBoardingEntity.description,
            style = TextStyle(fontSize = 16.sp, color = colorResource(R.color.text_medium)),
            modifier = Modifier.padding(horizontal = Dimies.smallPadding)
        )

    }
}

@Preview(showBackground = true)

@Composable
fun OnBoardingView() {
    MyApplicationTheme{
        OnBoardingItem(onBoardingEntity = pages[0])
    }

}