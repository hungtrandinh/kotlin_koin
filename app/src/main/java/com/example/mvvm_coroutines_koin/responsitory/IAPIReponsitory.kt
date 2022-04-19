package com.example.mvvm_coroutines_koin.responsitory

import com.example.mvvm_coroutines_koin.model.MovieTrendingList

interface IAPIReponsitory {
    suspend fun GetTrendingMovie(
         query: String
    ) : MovieTrendingList
}