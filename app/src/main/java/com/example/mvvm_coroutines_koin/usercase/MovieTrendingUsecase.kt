package com.example.mvvm_coroutines_koin.usercase

import com.example.mvvm_coroutines_koin.model.MovieResultTrending
import com.example.mvvm_coroutines_koin.responsitory.IAPIReponsitory

class MovieTrendingUsecase(val api : IAPIReponsitory) {
    suspend fun  GetTrendingMovie(
        query: String,
    ) : List<MovieResultTrending>{
        val reponse = api.GetTrendingMovie(query)
        return reponse.result
    }
}
