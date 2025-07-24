package com.example.myapplication.feature.home.domain.usecase

import androidx.compose.ui.text.toLowerCase
import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import java.util.Locale
import javax.inject.Inject

class SearchList @Inject constructor()  {
    fun invoke(newsList : List<NewsItemEntity>,query:String):List<NewsItemEntity>{
        var filteredList = mutableListOf<NewsItemEntity>()
        for (i in newsList){
            if(i.title.toLowerCase(Locale.ROOT).contains(query.toLowerCase())){
                filteredList.add(i)
            }
        }
        return filteredList

    }
}