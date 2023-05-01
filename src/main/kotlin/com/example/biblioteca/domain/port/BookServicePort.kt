package com.example.biblioteca.domain.port

import com.example.biblioteca.domain.model.Book

interface BookServicePort {
    fun createBook(book: Book): Book
    fun updateBook(book:Book): Book
    fun deleteBook(id: Long)
    fun findBookById(id: Long): Book?
    fun findAllBooks(): List<Book>
}