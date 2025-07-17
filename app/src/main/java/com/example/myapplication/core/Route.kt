package com.example.myapplication.core

sealed class Route(route:String) {
    object OnBoardingScreen :Route(route = "onBoardingScreen")
    object HomeScreen :Route(route = "homeScreen")
    object SearchScreen :Route(route = "searchScreen")
    object BookMarksScreen :Route(route = "bookMarksScreen")
    object DetailsScreen :Route(route = "detailsScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "newsNavigation")
    object NewsNavigatorScreen : Route(route = "newsNavigator")


}