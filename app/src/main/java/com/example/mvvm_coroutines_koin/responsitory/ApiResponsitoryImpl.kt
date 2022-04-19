package com.example.mvvm_coroutines_koin.responsitory

import com.example.mvvm_coroutines_koin.model.MovieTrendingList

class ApiResponsitoryImpl(val restApiClient: RestApiClient) : IAPIReponsitory {
    override suspend fun GetTrendingMovie(query: String): MovieTrendingList {
        return restApiClient.GetTrendingMovie(query)
    }
}