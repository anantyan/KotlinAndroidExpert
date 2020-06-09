package com.tutorial.views.activities

import com.tutorial.domain.models.ResponseEntity

interface MainActivityView {

    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(entity: ResponseEntity)
    fun onFailure(error: Throwable)
    fun onPagesResponse(entity: ResponseEntity)
    fun onPagesFailure(error: Throwable)
}