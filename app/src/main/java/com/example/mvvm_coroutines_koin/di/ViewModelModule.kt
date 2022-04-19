package com.example.mvvm_coroutines_koin.di

import com.example.mvvm_coroutines_koin.presentation.home.trendingmovie.MovieTrendingVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module{
    viewModel {
        MovieTrendingVM(get())  // khởi tao view model in module
    }
}