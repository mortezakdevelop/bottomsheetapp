package com.example.tigetprojectinhome.db

import androidx.room.TypeConverter
import com.example.tigetprojectinhome.model.MovieModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MovieTypeConverter {
    @TypeConverter
    fun toJson(moveModel: MovieModel):String?{

        if (moveModel == null){
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MovieModel?>(){}.type
        return gson.toJson(moveModel,type)

    }

    @TypeConverter
    fun toDataClass(note:String?):MovieModel?{
        if(note == null){
            return null
        }
        val gson = Gson()
        val type:Type = object :TypeToken<MovieModel?>(){}.type
        return gson.fromJson(note,type)
    }
}