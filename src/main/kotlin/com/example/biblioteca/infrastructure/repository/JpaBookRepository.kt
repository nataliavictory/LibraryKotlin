package com.example.biblioteca.infrastructure.repository

import com.example.biblioteca.domain.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaBookRepository : JpaRepository<Book, Long>
