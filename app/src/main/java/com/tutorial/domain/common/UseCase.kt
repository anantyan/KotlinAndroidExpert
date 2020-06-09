package com.tutorial.domain.common

import com.tutorial.domain.executor.PostExecutionThread
import com.tutorial.domain.executor.ThreadExecutor
import com.tutorial.domain.models.ResponseEntity
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, in Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private val disposable = CompositeDisposable()
    protected abstract fun buildUserCaseObservable(params: Params): Single<T>

    fun execute(observer: DefaultObserver<T>, params: Params) {
        buildUserCaseObservable(params)
            .observeOn(postExecutionThread.scheduler)
            .subscribeOn(Schedulers.from(threadExecutor))
            .subscribeWith(observer)
            .addTo(disposable)
    }

    fun dispose() {
        disposable.clear()
    }
}