package com.example.myapplication.feature

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.feature.home.presentation.HomeView
import com.example.myapplication.feature.saved.presentation.SavedView
import com.example.myapplication.feature.search.presentation.SearchView

@Composable
fun MainLayout(navController: NavController){
    val navList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Search", Icons.Default.Search),
        NavItem("Saved", Icons.Default.Menu),
    )

    var currentIndex by remember {
        mutableStateOf(0)
    }
    Scaffold (modifier = Modifier.fillMaxSize(), bottomBar = {
        NavigationBar {
            navList.forEachIndexed {index, navItem ->NavigationBarItem(
                selected = currentIndex==index,
                onClick = {
                    currentIndex=index
                },
                icon = { Icon(contentDescription = "icon", imageVector = navItem.icon) },
                label = {
                    Text(text = navItem.label)
                }
            )

            }
        }
    }) {

        ContentViewScreen(currentIndex,navController,Modifier.padding(it))
    }
}

@Composable
fun ContentViewScreen(index:Int,navController: NavController,modifier: Modifier=Modifier){
    when(index){
        0-> HomeView(navController = navController)
        1-> SearchView()
        2-> SavedView()

    }
}