package com.example.tigetprojectinhome.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tigetprojectinhome.db.AppDatabase
import com.example.tigetprojectinhome.db.entities.OfflinePageMovieEntity
import com.example.tigetprojectinhome.model.MovieModel
import com.example.tigetprojectinhome.model.OfflinePageMovieModel
import com.example.tigetprojectinhome.network.ApiService
import com.example.tigetprojectinhome.viewmodel.OfflineViewModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {

    companion object{
        private const val tag = "MovieRepository"
    }

    private val roomDao = appDatabase.roomDao()


    val getMovieModelLiveData:MutableLiveData<List<MovieModel>>
    get() {
        val data: MutableLiveData<List<MovieModel>> =
            MutableLiveData<List<MovieModel>>()
        apiService.getMovieList().enqueue(object :Callback<List<MovieModel>>{
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                Log.e(tag, "onResponse: " + response.code(), )
                if (response.isSuccessful){
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                print(t.message)
            }

        })
        return data
    }

    //get data from api
    fun getAllDataFromApiAndInsertDb(query:String?) {
        val call: Call<OfflinePageMovieModel> = apiService.getOfflineMovieList(query!!)
        call?.enqueue(object : Callback<OfflinePageMovieModel> {
            override fun onResponse(
                call: Call<OfflinePageMovieModel>,
                response: Response<OfflinePageMovieModel>
            ) {
                if (response.isSuccessful) {
                    response.body()?.data?.forEach {
                        insertData(it)
                    }
                    Log.d("logging", "Success")
                }
            }

            override fun onFailure(call: Call<OfflinePageMovieModel>, t: Throwable) {
                Log.d("logging", t.message.toString())
            }
        })
    }

//val getMovieModelLiveDataAndInsertToDb:MutableLiveData<OfflinePageMovieModel>
//    get() {
//        val data: MutableLiveData<OfflinePageMovieModel> =
//            MutableLiveData<OfflinePageMovieModel>()
//        apiService.getOfflineMovieList().enqueue(object :Callback<OfflinePageMovieModel>{
//
//            override fun onResponse(
//                call: Call<OfflinePageMovieModel>,
//                response: Response<OfflinePageMovieModel>
//            ) {
//                if (response.isSuccessful){
//                    response.body()?.data?.forEach {
//                        insertData(it)
//                    }
//
//                }            }
//
//            override fun onFailure(call: Call<OfflinePageMovieModel>, t: Throwable) {
//                print(t.message)            }
//
//        })
//        return data
//    }
//

    fun getAll(): LiveData<List<OfflinePageMovieEntity>> {
        Log.d("logging", "get all records from LiveData")
        return roomDao.getAll()
    }

    fun insertData(offlinePageMovieModel: OfflinePageMovieEntity) {
        Log.d("logging", "insert record to DB")
        roomDao.insert(offlinePageMovieModel)
    }


}
