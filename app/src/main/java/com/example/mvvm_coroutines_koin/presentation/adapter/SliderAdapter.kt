//package com.example.mvvm_coroutines_koin.presentation.adapter
//
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//
//import com.example.mvvm_coroutines_koin.databinding.ImageSliderBinding
//import com.example.mvvm_coroutines_koin.model.MovieResultTrending
//
//import com.smarteist.autoimageslider.R
//import com.smarteist.autoimageslider.SliderViewAdapter
//import java.util.zip.Inflater
//
//
//class SliderAdapter : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {
//
////    val _movieTrending = MutableSharedFlow<StateMovie>()
////    val  movieTrending : SharedFlow<StateMovie> = _movieTrending
////    val _movieTrendingStateFlow = MutableStateFlow<List<MovieResultTrending>>(listOf())
////    val movieTrendingStateFlow = _movieTrendingStateFlow
////    b
////  private  val movieResultTrending : List<MovieResultTrending>? = null
////    lateinit var  binding: ImageSliderBinding
////    fun renewItem(sliderItem :List<MovieResultTrending>){
////       var movieResultTrending = sliderItem
////        notifyDataSetChanged()
////    }
////    override fun getCount(): Int {
////       movieResultTrending!!.size
////    }
////
////    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
////       var inflater :View = LayoutInflater.from(parent.context).inflate(R.layout)
////        return SliderAdapterVH(binding.imageSlider)
////
////
////
////    }
////
////    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {
////        TODO("Not yet implemented")
////    }
////   inner class  SliderAdapterVH(viewiteam :View?) :ViewHolder(viewiteam){
////       val imageView :ImageView  = viewiteam!!.findViewById(R.layout. )
////   }
//
//}
//
//
//
//sealed class StateMovie{
//    object movieTrending : StateMovie()
//
//}
