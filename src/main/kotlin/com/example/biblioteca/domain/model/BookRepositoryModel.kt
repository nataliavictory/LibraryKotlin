package com.example.biblioteca.domain.model

interface BookRepositoryModel {
    fun create(book: Book): Book
    fun update(book: Book): Book
    fun delete(id: String)
    fun findBookById(id: String): Book
    fun findAll(): List<Book>
}