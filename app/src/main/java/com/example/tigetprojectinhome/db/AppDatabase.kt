package com.example.tigetprojectinhome.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tigetprojectinhome.db.dao.RoomDao
import com.example.tigetprojectinhome.db.entities.MovieEntity
import com.example.tigetprojectinhome.db.entities.OfflinePageMovieEntity

@TypeConverters(MovieTypeConverter::class)
@Database(entities = [OfflinePageMovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun roomDao(): RoomDao
}