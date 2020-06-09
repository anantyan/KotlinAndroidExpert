package com.tutorial.domain

import com.tutorial.data.factories.MainFactory
import com.tutorial.data.models.MainModel
import com.tutorial.data.models.ResponseModel
import com.tutorial.domain.models.MainEntity
import com.tutorial.domain.models.ResponseEntity
import io.reactivex.Single

class MainRepositoryImpl(
    private val factory: MainFactory
): MainRepository {
    override fun discoverMovie(param: MainParam): Single<ResponseEntity> {
        return factory.discoverMovie(param.page).map {
            t: ResponseModel ->  ResponseEntity(
            t.page?: -1L,
            t.total_pages?: -1L,
            t.results?.map {
                model: MainModel -> MainEntity(
                model.title?: "Untitled",
                model.overview?: "No Description"
            )}?.toMutableList()?: mutableListOf()
        )}
    }
}