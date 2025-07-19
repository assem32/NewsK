package com.example.myapplication.feature.boardingScreen.domain.entity

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class OnBoardingEntity(
    val title :String,
    val description:String,
    @DrawableRes val image:Int
)

val pages = listOf(
    OnBoardingEntity(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding1
    ),
    OnBoardingEntity(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding2
    ),
    OnBoardingEntity(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding3
    )
)
