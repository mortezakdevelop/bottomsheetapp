package com.example.tigetprojectinhome.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tigetprojectinhome.adapter.MovieAdaper
import com.example.tigetprojectinhome.adapter.OfflinePageAdapter
import com.example.tigetprojectinhome.databinding.FragmentOnlineBinding
import com.example.tigetprojectinhome.viewmodel.OfflineViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OfflinePageFragment : Fragment() {

    private lateinit var fragmentOnlineBinding: FragmentOnlineBinding
    private val viewModel: OfflineViewModel by viewModels()
    private lateinit var recyclerViewAdapter: OfflinePageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentOnlineBinding = FragmentOnlineBinding.inflate(layoutInflater,container,false)
        initMainViewModel()
        initViewModel()
        return fragmentOnlineBinding.root
    }
    private fun initViewModel() {
        fragmentOnlineBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())

            val decoration =
                DividerItemDecoration(requireActivity().applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
             recyclerViewAdapter = OfflinePageAdapter()
            adapter = recyclerViewAdapter
            Log.d("logging", "prepare ViewModel")
        }
    }

    private fun initMainViewModel() {
        viewModel.getAllFromDb().observe(viewLifecycleOwner) {
            recyclerViewAdapter.listDataUser
            recyclerViewAdapter.notifyDataSetChanged()
        }
        viewModel.getMovieModelLiveDataAndInsertToDb()
        Log.d("logging", "make Main ViewModel")
    }
}