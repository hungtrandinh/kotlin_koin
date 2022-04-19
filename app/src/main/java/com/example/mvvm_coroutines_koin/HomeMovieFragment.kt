package com.example.mvvm_coroutines_koin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import com.example.mvvm_coroutines_koin.databinding.FragmentHomeMovieBinding
import com.example.mvvm_coroutines_koin.model.MovieResultTrending
import com.example.mvvm_coroutines_koin.presentation.adapter.SliderAdapter
import com.example.mvvm_coroutines_koin.presentation.home.trendingmovie.MovieTrendingVM
import com.smarteist.autoimageslider.SliderView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeMovieFragment : Fragment() {
  private var binding: FragmentHomeMovieBinding? =null
    private val movietrendingVM : MovieTrendingVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            binding = FragmentHomeMovieBinding.inflate(inflater,container,false)
            return  binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      var movieResultTrending : List<MovieResultTrending>
        super.onViewCreated(view, savedInstanceState)
        val imageSlider = binding!!.scree1
        binding!!.scree1.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_homeMovieFragment_to_movieFragment)
        }
       lifecycleScope.launch(){
           repeatOnLifecycle(Lifecycle.State.STARTED){
               movietrendingVM.movieTrendingStateFlow.collectLatest {
                   movietrending -> movieResultTrending = movietrending
                   setImageSlider(movieResultTrending,imageSlider)
               }
           }
       }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    private fun setImageSlider(image : List<MovieResultTrending>, imageSlider : SliderView) {
        val adapter = SliderAdapter()
        adapter.renewItem(image)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle =true
        imageSlider.startAutoCycle()

    }


//    {
////        binding = FragmentHomeMovieBinding.inflate(layoutInflater)
////
////        super.onCreate(savedInstanceState)
////
////        binding.scree1.setOnClickListener(){
////            Navigation.findNavController(view!!).navigate(R.id.action_homeMovieFragment_to_movieFragment)
////        }
//
//    }


}