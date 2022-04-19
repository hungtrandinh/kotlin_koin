package com.example.mvvm_coroutines_koin.responsitory

import com.example.mvvm_coroutines_koin.model.MovieTrendingList
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiClient {
    @GET("trending/all/day")
    suspend fun GetTrendingMovie(
        @Query("api_key") query: String,
    ) : MovieTrendingList
}