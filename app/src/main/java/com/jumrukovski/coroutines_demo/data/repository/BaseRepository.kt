package com.jumrukovski.coroutines_demo.data.repository

import android.util.Log
import com.jumrukovski.coroutines_demo.data.model.ResponseStatus
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> apiCall(call: suspend () -> Response<T>, error: String): T? {
        val result = apiResponse(call, error)
        var output: T? = null
        when (result) {
            is ResponseStatus.Success ->
                output = result.output
            is ResponseStatus.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }

    private suspend fun <T : Any> apiResponse(call: suspend () -> Response<T>, error: String): ResponseStatus<T> {
        val response = call.invoke()
        return if (response.isSuccessful)
            ResponseStatus.Success(response.body()!!)
        else
            ResponseStatus.Error(IOException("OOps .. Something went wrong due to $error"))
    }
}