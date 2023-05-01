package com.example.biblioteca.infrastructure.dto

data class BookDto(
    val id: Long,
    var title: String,
    var author: String
)

data class BookDtoResponse(
    var title: String,
    var author: String
)