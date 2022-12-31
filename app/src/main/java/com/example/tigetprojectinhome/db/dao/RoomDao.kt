package com.example.tigetprojectinhome.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tigetprojectinhome.db.entities.OfflinePageMovieEntity
import com.example.tigetprojectinhome.model.OfflinePageMovieModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Query("SELECT * FROM movie_table")
    fun getAll(): LiveData<List<OfflinePageMovieEntity>>

    @Insert
    fun insert(movieEntity: OfflinePageMovieEntity)
}