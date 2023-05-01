package com.example.biblioteca.application

import com.example.biblioteca.domain.model.Book
import com.example.biblioteca.domain.port.BookServicePort
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class BookApplicationService(
    private val bookServicePort: BookServicePort
) {
    fun createBook(command: BookCommand.Create): Book  {
        val book = Book(
            id = UUID.randomUUID().getLeastSignificantBits(),
            title = command.title,
            author = command.author
        )
        return bookServicePort.createBook(book)
    }

    fun updateBook(command: BookCommand.Update): Book {
        val book = bookServicePort.findBookById(command.id)
        ?: throw RuntimeException("Book not found with id: ${command.id}")

        book.title = command.title
        book.author = command.author

        return bookServicePort.updateBook(book)
    }

    fun deleteBook(command: BookCommand.Delete) {
        val book = bookServicePort.findBookById(command.id)
            ?: throw RuntimeException("Book not found with id: ${command.id}")
        bookServicePort.deleteBook(command.id)
    }

    fun findById(command: BookCommand.FindById): Book? {
        return bookServicePort.findBookById(command.id)
    }

    fun findAll(): List<Book> {
        return bookServicePort.findAllBooks()
    }
}