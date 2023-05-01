package com.example.biblioteca.infrastructure.http.controller

import com.example.biblioteca.application.BookApplicationService
import com.example.biblioteca.application.BookCommand
import com.example.biblioteca.domain.model.Book
import com.example.biblioteca.infrastructure.dto.BookDto
import com.example.biblioteca.infrastructure.dto.BookDtoResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
@RequestMapping("v1/api/books")
class BookController(
    private val bookApplicationService: BookApplicationService,
    private val mapper: ObjectMapper
) {

    @PostMapping
    fun create(@RequestBody bookDto: BookDto): ResponseEntity<BookDtoResponse> {
        val bookMapper = mapper.convertValue(bookDto, Book::class.java)
        val command = BookCommand.Create(
            id = bookMapper.id,
            title = bookMapper.title,
            author = bookMapper.author
        )
        val book = bookApplicationService.createBook(command)
        val bookCreated =  mapper.convertValue(book, BookDtoResponse::class.java)
        return ResponseEntity(bookCreated, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long , @RequestBody bookDto: BookDto): ResponseEntity<BookDtoResponse> {
        val bookMapper = mapper.convertValue(bookDto, Book::class.java)
        val command = BookCommand.Update(
            id = id,
            title = bookMapper.title,
            author = bookMapper.author
        )

        return try {
            val book = bookApplicationService.updateBook(command)
            val bookCreated =  mapper.convertValue(book, BookDtoResponse::class.java)
            ResponseEntity(bookCreated, HttpStatus.OK)
        } catch (e: RuntimeException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        val command = BookCommand.Delete(id = id)
        bookApplicationService.deleteBook(command)

        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{id}")
    fun findBookById(@PathVariable id: Long): ResponseEntity<BookDtoResponse> {
        val command = BookCommand.FindById(id = id)
        val book = bookApplicationService.findById(command)?: return ResponseEntity(HttpStatus.NOT_FOUND)
        val bookDto = mapper.convertValue(book, BookDtoResponse::class.java)

        return ResponseEntity(bookDto, HttpStatus.OK)
    }

    @GetMapping()
    fun findAll(): ResponseEntity<List<BookDto>> {
        val books = bookApplicationService.findAll()
        val bookDto = mapper.convertValue(books, Array<BookDto>::class.java).toList()

        return ResponseEntity(bookDto, HttpStatus.FOUND)
    }
}