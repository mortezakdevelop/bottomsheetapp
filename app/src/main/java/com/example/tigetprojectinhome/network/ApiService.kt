package com.example.tigetprojectinhome.network

import com.example.tigetprojectinhome.model.MovieModel
import com.example.tigetprojectinhome.model.OfflinePageMovieModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("marvel")
    fun getMovieList():Call<List<MovieModel>>

     @GET("users")
    fun getOfflineMovieList(@Query("page") query: String):Call<OfflinePageMovieModel>


}