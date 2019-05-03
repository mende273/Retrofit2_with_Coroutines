package com.jumrukovski.coroutines_demo.domain

import androidx.lifecycle.LiveData
import com.jumrukovski.coroutines_demo.base.BaseUseCase
import com.jumrukovski.coroutines_demo.data.model.ApiResponse
import com.jumrukovski.coroutines_demo.data.model.Item
import com.jumrukovski.coroutines_demo.data.repository.TvRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MostPopularUseCase @Inject constructor(private val repository: TvRepository, private val scope: CoroutineScope) :
    BaseUseCase<ApiResponse<List<Item>>>() {

    override fun getItems(language: String, page: Int): LiveData<ApiResponse<List<Item>>> {
        scope.launch {
            response.postValue(repository.getPopularTvShows(language, page))
        }

        return response
    }

    override fun clearJob() {
        scope.coroutineContext.cancel()
    }
}