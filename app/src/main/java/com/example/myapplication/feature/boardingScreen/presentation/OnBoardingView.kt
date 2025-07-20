package com.example.myapplication.feature.boardingScreen.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.feature.boardingScreen.domain.entity.pages
import com.example.myapplication.feature.boardingScreen.presentation.component.IndicatorComponent
import com.example.myapplication.feature.boardingScreen.presentation.component.OnBoardingItem
import com.example.myapplication.core.Dimens
import com.example.myapplication.core.commonComposable.NewsButton
import com.example.myapplication.core.navGraph.Route
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@Composable
fun BoardingScreen(modifier: Modifier = Modifier,navController: NavController) {
    Column(modifier = modifier.fillMaxSize()) {
        val pageState = rememberPagerState(initialPage = 0) { pages.size }
        val animation = rememberCoroutineScope()

        val buttonsState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }
        HorizontalPager(state = pageState) { index ->
            OnBoardingItem(onBoardingEntity = pages[index])
        }
        Spacer(modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.smallPadding)) {
            IndicatorComponent(
                modifier = Modifier.width(52.dp),
                pageSize = pages.size,
                selectedPage = pageState.currentPage
            )

            Row{
                if (pageState.currentPage != 0)
                    NewsButton("Back", color = Color.DarkGray, onClick = {
                        animation.launch {
                            pageState.animateScrollToPage(pageState.currentPage - 1)
                        }
                    })
                Spacer(modifier.width(10.dp))
                NewsButton(if (pageState.currentPage + 1 == pages.size) "Keep Going" else "Next") {
                    if (pageState.currentPage + 1 == pages.size) {
                        navController.navigate(Route.homeScreen)

                    } else {
                        animation.launch {
                            pageState.animateScrollToPage(pageState.currentPage + 1)
                        }
                    }

                }
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    MyApplicationTheme{
//        BoardingScreen()
    }

}