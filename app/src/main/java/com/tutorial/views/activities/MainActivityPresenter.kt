package com.tutorial.views.activities

import com.tutorial.domain.MainParam
import com.tutorial.domain.MainUseCase
import com.tutorial.domain.common.DefaultObserver
import com.tutorial.domain.models.MainEntity
import com.tutorial.domain.models.ResponseEntity

class MainActivityPresenter(
    private val listener: MainActivityView,
    private val useCase: MainUseCase
) {
    fun discoverMovie() {
        listener.onShowLoading()
        useCase.execute(
            DiscoverMovie(listener),
            MainParam()
        )
    }

    fun loadMoreMovie(page: Long) {
        useCase.execute(
            LoadMoreMovie(listener),
            MainParam(page)
        )
    }

    fun detachMovie() {
        useCase.dispose()
    }

    class DiscoverMovie(private val listener: MainActivityView) : DefaultObserver<ResponseEntity>() {
        override fun onSuccess(t: ResponseEntity) {
            listener.onShowLoading()
            listener.onResponse(t)
        }

        override fun onError(e: Throwable) {
            listener.onHideLoading()
            listener.onFailure(e)
        }
    }

    class LoadMoreMovie(private val listener: MainActivityView) : DefaultObserver<ResponseEntity>() {
        override fun onSuccess(t: ResponseEntity) {
            listener.onPagesResponse(t)
        }

        override fun onError(e: Throwable) {
            listener.onPagesFailure(e)
        }
    }
}
