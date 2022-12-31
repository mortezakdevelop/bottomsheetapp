package com.example.tigetprojectinhome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tigetprojectinhome.model.MovieModel
import com.example.tigetprojectinhome.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
):ViewModel() {

//    private val movieRepository:MovieRepository
    val getMovieList:LiveData<List<MovieModel>>
        get() {
           return movieRepository.getMovieModelLiveData
        }
//    init {
//        movieRepository = MovieRepository()
//    }
}