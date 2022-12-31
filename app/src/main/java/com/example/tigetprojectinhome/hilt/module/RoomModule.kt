package com.example.tigetprojectinhome.hilt.module

import android.app.Application
import androidx.room.Room
import com.example.tigetprojectinhome.db.AppDatabase
import com.example.tigetprojectinhome.db.dao.RoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "movie_table").build()

    @Provides
    @Singleton
    fun provideRoomDao(appDatabase: AppDatabase): RoomDao {
        return appDatabase.roomDao()
    }
}

