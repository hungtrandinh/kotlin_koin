package com.example.mvvm_coroutines_koin.model

import com.google.gson.annotations.SerializedName


data class MovieResultTrending(
    @SerializedName("release_date") val release : String,
    @SerializedName("backdrop_path") val backdrop_path : String? = null,
    @SerializedName("original_title") val original_title : String,
    @SerializedName("title") val title : String,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("overview") val overview : String,
    @SerializedName("poster_path") val poster_path: String? = null,


    )
