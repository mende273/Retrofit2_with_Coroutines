package com.jumrukovski.coroutines_demo.data.model


data class ApiResponse<T>(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: T
)