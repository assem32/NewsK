package com.example.myapplication.core

sealed class BaseStates <out T>{
    object Loading : BaseStates<Nothing>()
    data class Success<T> (val data : T) : BaseStates<T>()
    data class Error (val message : String):BaseStates<Nothing>()
}