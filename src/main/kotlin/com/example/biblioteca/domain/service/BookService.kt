package com.example.biblioteca.domain.service

import com.example.biblioteca.domain.model.Book
import com.example.biblioteca.domain.port.BookRepositoryPort
import com.example.biblioteca.domain.port.BookServicePort
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepositoryPort: BookRepositoryPort
    ): BookServicePort {
    override fun createBook(book: Book): Book {
        return bookRepositoryPort.create(book)
    }

    override fun updateBook(book: Book): Book {
        return bookRepositoryPort.update(book)
    }

    override fun deleteBook(id: Long) {
        return bookRepositoryPort.delete(id)
    }

    override fun findBookById(id: Long): Book? {
        return bookRepositoryPort.findById(id)
    }

    override fun findAllBooks(): List<Book> {
        return bookRepositoryPort.findAll()
    }
}