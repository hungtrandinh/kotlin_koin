package com.example.mvvm_coroutines_koin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


import com.example.mvvm_coroutines_koin.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
   private var  binding: FragmentMovieBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater,container,false)
       return  binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.screen2.setOnClickListener(){
              Navigation.findNavController(view).navigate(R.id.action_movieFragment_to_homeMovieFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding =null
    }


}