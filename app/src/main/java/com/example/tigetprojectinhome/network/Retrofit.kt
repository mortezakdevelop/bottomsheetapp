package com.example.tigetprojectinhome.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

//    var retrofit:Retrofit? = null
//    fun getRetrofitClient(baseUrl:String):Retrofit{
//
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val okHttpClient:OkHttpClient =
//            OkHttpClient.Builder()
//                .readTimeout((68*2).toLong(),TimeUnit.SECONDS)
//                .connectTimeout((68*2).toLong(),TimeUnit.SECONDS)
//                .writeTimeout((68*2).toLong(),TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .build()
//
//        if (retrofit == null){
//            retrofit = Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build()
//        }
//        return retrofit!!
//    }
}