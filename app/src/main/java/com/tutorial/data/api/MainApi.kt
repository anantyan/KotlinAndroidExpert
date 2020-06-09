package com.tutorial.data.api

import com.tutorial.BuildConfig
import com.tutorial.data.models.ResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Long
    ): Single<ResponseModel>
}