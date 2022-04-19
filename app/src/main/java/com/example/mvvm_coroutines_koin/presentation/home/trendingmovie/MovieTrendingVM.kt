package com.example.mvvm_coroutines_koin.presentation.home.trendingmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_coroutines_koin.model.MovieResultTrending
import com.example.mvvm_coroutines_koin.usercase.MovieTrendingUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MovieTrendingVM(val movieTrendingUsecase: MovieTrendingUsecase) : ViewModel() {

    val _movieTrending = MutableSharedFlow<StateVM>()
    val  movieTrending : SharedFlow<StateVM> = _movieTrending

    val _movieTrendingStateFlow = MutableStateFlow<List<MovieResultTrending>>(listOf())
    val movieTrendingStateFlow = _movieTrendingStateFlow

    init {
        TrendingMovie()
    }
    fun TrendingMovie(){
        viewModelScope.launch(Dispatchers.IO) {
            val reponse = movieTrendingUsecase.GetTrendingMovie("3871ad6519572fdaf1577d755ac3f7a5")
            movieTrendingStateFlow.value = reponse
        }

    }


}

sealed class StateVM {
    object TrendingMovie: StateVM()
}