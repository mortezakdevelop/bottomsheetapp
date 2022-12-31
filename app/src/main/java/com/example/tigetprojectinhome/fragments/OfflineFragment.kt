package com.example.tigetprojectinhome.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tigetprojectinhome.adapter.MovieAdaper
import com.example.tigetprojectinhome.databinding.FragmentOfflineBinding
import com.example.tigetprojectinhome.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OfflineFragment : Fragment() {

    private lateinit var fragmentOfflineBinding: FragmentOfflineBinding
    private val viewModel:MovieViewModel by viewModels()
    lateinit var adapter:MovieAdaper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentOfflineBinding = FragmentOfflineBinding.inflate(layoutInflater,container,false)
        observe()
        return fragmentOfflineBinding.root
    }

    private fun observe(){
        viewModel.getMovieList.observe(viewLifecycleOwner){moveModel ->
            Log.e("TAG", "observe: " + moveModel[0].name, )
            adapter = MovieAdaper(moveModel)
            fragmentOfflineBinding.recyclerView.adapter = adapter
        }
    }
}