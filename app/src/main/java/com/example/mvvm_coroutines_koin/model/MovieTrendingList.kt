package com.example.mvvm_coroutines_koin.model


import com.google.gson.annotations.SerializedName

data class MovieTrendingList(
    @SerializedName("page") val page : Int,
    @SerializedName("total_pages") val total_pages :Int,
    @SerializedName("total_results") val total_results : Int,
    @SerializedName("results") val result: List<MovieResultTrending>
)

