package com.example.biblioteca.infrastructure.repository

import com.example.biblioteca.domain.model.Book
import com.example.biblioteca.domain.port.BookRepositoryPort
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl(
    private val jpaBookRepository: JpaBookRepository
): BookRepositoryPort {
    override fun create(book: Book): Book {
        return jpaBookRepository.save(book)
    }

    override fun update(book: Book): Book {
        return jpaBookRepository.save(book)
    }

    override fun delete(id: Long) {
        return jpaBookRepository.deleteById(id)
    }

    override fun findById(id: Long): Book {
        return jpaBookRepository.getReferenceById(id)
    }

    override fun findAll(): List<Book> {
        return jpaBookRepository.findAll()
    }
}