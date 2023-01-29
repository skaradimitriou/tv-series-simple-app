package com.example.data.network

import com.example.data.models.TvShowDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TvShowsService {

    private val logger = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder().addInterceptor(logger).build()

    private val api = Retrofit.Builder()
        .baseUrl("https://api.tvmaze.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Endpoints::class.java)

    fun getTvShows(): List<TvShowDto?> = listOf()
}