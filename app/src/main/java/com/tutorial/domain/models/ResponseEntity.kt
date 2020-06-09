package com.tutorial.domain.models

data class ResponseEntity(
    val page: Long,
    val total_page: Long,
    val results: List<MainEntity>
)