package com.example.mvvm_coroutines_koin.di

import com.example.mvvm_coroutines_koin.responsitory.ApiResponsitoryImpl
import com.example.mvvm_coroutines_koin.responsitory.IAPIReponsitory
import com.example.mvvm_coroutines_koin.responsitory.RestApiClient
import com.example.mvvm_coroutines_koin.usercase.MovieTrendingUsecase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { providerRetrofitBuide() }
    single { providerFunCloudRetrofit(get()) }
    single<IAPIReponsitory> { ApiResponsitoryImpl(get())  }
    single  { MovieTrendingUsecase(get()) }

}
internal fun providerRetrofitBuide() : Retrofit.Builder{
    return  Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
}
internal fun providerFunCloudRetrofit(
    builder: Retrofit.Builder
) : RestApiClient {
    return  builder
        .build()
        .create(RestApiClient::class.java)
}
