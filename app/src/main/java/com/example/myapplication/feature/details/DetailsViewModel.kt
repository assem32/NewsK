package com.example.myapplication.feature.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.BaseStates
import com.example.myapplication.feature.home.data.local.DAO
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(val dao: DAO):ViewModel() {

    private var _savedList = MutableLiveData<BaseStates<List<NewsItemEntity>>>()
    val savedList : LiveData<BaseStates<List<NewsItemEntity>>> = _savedList

     fun saveNews(newsItemEntity: NewsItemEntity){
        viewModelScope.launch {
            dao.insertNewsItem(newsItemEntity)

        }
    }
    fun getSavedNews(){
        viewModelScope.launch {
            _savedList.value = BaseStates.Loading
           try {
               val data = dao.getAllNews()
               _savedList.value = BaseStates.Success(data);
           }catch (e:Exception){
               _savedList.value=BaseStates.Error(e.message ?:"");
           }
            Log.d("local" , ""+_savedList)
        }
    }


}