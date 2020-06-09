package com.tutorial.data.factories

import com.tutorial.BuildConfig
import com.tutorial.data.api.MainApi
import com.tutorial.data.models.ResponseModel
import io.reactivex.Single

class MainFactory(
    private val mainApi: MainApi
) {
    fun discoverMovie(page: Long): Single<ResponseModel> {
        return mainApi.discoverMovie(BuildConfig.API_KEY, page)
    }
}