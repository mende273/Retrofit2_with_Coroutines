package com.jumrukovski.coroutines_demo.data.repository

import com.jumrukovski.coroutines_demo.data.model.ApiResponse
import com.jumrukovski.coroutines_demo.data.model.Item
import com.jumrukovski.coroutines_demo.network.ApiService
import javax.inject.Inject

class TvRepository @Inject constructor(private val apiService: ApiService, private val apiKey: String) :
    BaseRepository() {

    suspend fun getPopularTvShows(language: String, page: Int): ApiResponse<List<Item>> {
        val response = apiCall(
            call = { apiService.getPopularTvShows(apiKey, language, page).await() },
            error = "Error fetching Popular Tv Shows"
        )

        return response!!
    }

    suspend fun getTopRatedTvShows(language: String, page: Int): ApiResponse<List<Item>> {
        val response = apiCall(
            call = { apiService.getTopRatedTvShows(apiKey, language, page).await() },
            error = "Error fetching Top Rated Tv Shows"
        )

        return response!!
    }

}