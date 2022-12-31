package com.example.tigetprojectinhome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tigetprojectinhome.db.entities.MovieEntity
import com.example.tigetprojectinhome.db.entities.OfflinePageMovieEntity
import com.example.tigetprojectinhome.model.MovieModel
import com.example.tigetprojectinhome.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class OfflineViewModel @Inject constructor(
    private val movieRepository: MovieRepository
):ViewModel() {

    fun getAllFromDb():LiveData<List<OfflinePageMovieEntity>> {
        return movieRepository.getAll()
    }

    fun getMovieModelLiveDataAndInsertToDb() {
        movieRepository.getAllDataFromApiAndInsertDb("2")
    }
}