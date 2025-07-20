package com.example.myapplication.feature.home.presentation

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import com.example.myapplication.feature.home.domain.usecase.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getNews: GetNews) : ViewModel() {

    private val _newsListMutableLiveData = MutableLiveData<BaseStates<List<NewsItemEntity>>>()
    val newsListLiveData :LiveData<BaseStates<List<NewsItemEntity>>> = _newsListMutableLiveData

    fun getNews(){
        viewModelScope.launch {
            _newsListMutableLiveData.value = BaseStates.Loading

            _newsListMutableLiveData.value = getNews.invoke()
        }
    }

    @Composable
    fun openWebView(url:String){
        AndroidView(
            factory = {
                WebView(it).apply {
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
            }
        )
    }
}