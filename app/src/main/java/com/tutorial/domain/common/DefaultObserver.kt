package com.tutorial.domain.common

import io.reactivex.observers.DisposableSingleObserver

abstract class DefaultObserver<T>: DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {}
    override fun onError(e: Throwable) {}
}