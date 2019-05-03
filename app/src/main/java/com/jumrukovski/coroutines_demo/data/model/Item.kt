package com.jumrukovski.coroutines_demo.data.model


data class Item(
    val original_name: String,
    val name: String,
    val popularity: Float,
    val vote_count: Long,
    val first_air_date: String,
    val backdrop_path: String,
    val original_language: String,
    val id: Long,
    val vote_average: Float,
    val overview: String,
    val poster_path: String,
    val genre_ids: List<Int>,
    val origin_country: List<String>
)