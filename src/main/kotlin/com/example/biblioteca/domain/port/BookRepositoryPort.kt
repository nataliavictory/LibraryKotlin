package com.example.biblioteca.domain.port

import com.example.biblioteca.domain.model.Book

interface BookRepositoryPort {
    fun create(book: Book): Book
    fun update(book: Book): Book
    fun delete(id: Long)
    fun findById(id: Long): Book
    fun findAll(): List<Book>
}