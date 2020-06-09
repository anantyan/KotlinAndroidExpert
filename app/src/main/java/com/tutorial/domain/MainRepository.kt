package com.tutorial.domain

import com.tutorial.domain.models.MainEntity
import com.tutorial.domain.models.ResponseEntity
import io.reactivex.Single

interface MainRepository {
    fun discoverMovie(param: MainParam): Single<ResponseEntity>
}