package com.example.tigetprojectinhome.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tigetprojectinhome.model.MovieModel

@Entity(tableName = "movie_table")
data class OfflinePageMovieEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    val name:String,
    val realName:String,
    val team:String,)
