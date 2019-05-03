package com.jumrukovski.coroutines_demo.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jumrukovski.coroutines_demo.data.model.ApiResponse
import com.jumrukovski.coroutines_demo.data.model.Item
import com.jumrukovski.coroutines_demo.domain.MostPopularUseCase
import com.jumrukovski.coroutines_demo.domain.TopRatedUseCase
import javax.inject.Inject

class MainActivityVM @Inject constructor(
    private val topRatedUseCase: TopRatedUseCase,
    private val mostPopularUseCase: MostPopularUseCase
) : ViewModel() {

    fun getTopRatedShows(): LiveData<ApiResponse<List<Item>>> {
        return topRatedUseCase.getItems("en",1)
    }

    fun getMostPopularShows(): LiveData<ApiResponse<List<Item>>> {
        return mostPopularUseCase.getItems("en",1)
    }

    override fun onCleared() {
        super.onCleared()
        topRatedUseCase.clearJob()
        mostPopularUseCase.clearJob()
    }
}