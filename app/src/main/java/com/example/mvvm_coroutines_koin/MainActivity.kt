package com.example.mvvm_coroutines_koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.lifecycle.*
import com.example.mvvm_coroutines_koin.databinding.ActivityMainBinding
import com.example.mvvm_coroutines_koin.model.MovieResultTrending
import com.example.mvvm_coroutines_koin.presentation.adapter.SliderAdapter

import com.example.mvvm_coroutines_koin.presentation.home.trendingmovie.MovieTrendingVM
import com.example.mvvm_coroutines_koin.presentation.home.trendingmovie.StateVM
import com.smarteist.autoimageslider.SliderView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val movieTrendingVM : MovieTrendingVM by viewModel()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launchWhenStarted {
            movieTrendingVM.movieTrending.collect { movie ->
//                binding.textview.text = movie.first().title
            }
        }


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                movieTrendingVM.movieTrending.collect { state ->
                    when(state) {
                        is StateVM.TrendingMovie -> {
                            movieTrendingVM.TrendingMovie()
                        }
                    }
                }

            }
        }
        lifecycleScope.launch(Dispatchers.Main) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                movieTrendingVM.movieTrendingStateFlow.collectLatest { movies ->
//                    if (movies.isNotEmpty())
////                    binding.textview.text = movies[0].title
                }

            }
        }

    }

}
//collect su dung de lay het trang thai
// collectLatest lay trang thai cuoi cung