package com.jumrukovski.coroutines_demo.network

import com.jumrukovski.coroutines_demo.data.model.ApiResponse
import com.jumrukovski.coroutines_demo.data.model.Item
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val ENDPOINT = "http://api.themoviedb.org/3/"
    }

    @GET("tv/popular/")
    fun getPopularTvShows(@Query("api_key") apiKey: String, @Query("language") language: String, @Query("page") page: Int): Deferred<Response<ApiResponse<List<Item>>>>

    @GET("tv/top_rated")
    fun getTopRatedTvShows(
        @Query("api_key") apiKey: String, @Query("language") language: String, @Query("page") page: Int
    ): Deferred<Response<ApiResponse<List<Item>>>>
}