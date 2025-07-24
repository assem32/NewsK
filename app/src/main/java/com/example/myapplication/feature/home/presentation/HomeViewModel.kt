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
import com.example.myapplication.feature.home.domain.usecase.SearchList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getNews: GetNews,val searchUseCase: SearchList) : ViewModel() {

    private val _newsListMutableLiveData = MutableLiveData<BaseStates<List<NewsItemEntity>>>()
    val newsListLiveData :LiveData<BaseStates<List<NewsItemEntity>>> = _newsListMutableLiveData

    private val _filteredListMutableLiveData = MutableLiveData<BaseStates<List<NewsItemEntity>>>()
    val filteredListLiveData :LiveData<BaseStates<List<NewsItemEntity>>> = _filteredListMutableLiveData

    fun getNews(){
        viewModelScope.launch {
            _newsListMutableLiveData.value = BaseStates.Loading

            _newsListMutableLiveData.value = getNews.invoke()
            _filteredListMutableLiveData.value=_newsListMutableLiveData.value
        }
    }

    fun searchList(newList: List<NewsItemEntity>,query:String){
        Log.d("search", query)
        _filteredListMutableLiveData.value = BaseStates.Loading
        if(query!=null){
            var filtered : List<NewsItemEntity>
            filtered = searchUseCase.invoke(newsList = newList, query = query)
            if (filtered.isEmpty()){
                _filteredListMutableLiveData.value = BaseStates.Error("No Items Found")
            }
            else
                _filteredListMutableLiveData.value=BaseStates.Success(filtered)

        }
        else {
            _filteredListMutableLiveData.value= _newsListMutableLiveData.value
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