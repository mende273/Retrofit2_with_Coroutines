package com.jumrukovski.coroutines_demo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class BaseUseCase<T> {

    protected val response = MutableLiveData<T>()

    abstract fun getItems(language: String, page: Int): LiveData<T>

    abstract fun clearJob()
}