package com.tutorial.domain

import com.tutorial.domain.common.UseCase
import com.tutorial.domain.executor.JobExecutor
import com.tutorial.domain.executor.UIThread
import com.tutorial.domain.models.MainEntity
import com.tutorial.domain.models.ResponseEntity
import io.reactivex.Single

class MainUseCase (
    private val repository: MainRepository,
    executor: JobExecutor,
    uiThread: UIThread
): UseCase<ResponseEntity, MainParam>(executor, uiThread) {
    override fun buildUserCaseObservable(params: MainParam): Single<ResponseEntity> {
        return repository.discoverMovie(params)
    }
}