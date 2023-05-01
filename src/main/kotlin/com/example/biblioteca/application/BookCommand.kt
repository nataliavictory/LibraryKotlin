package com.example.biblioteca.application

sealed class BookCommand {
    data class Create(
        val id: Long,
        val title: String,
        val author: String
    ):BookCommand()

    data class Update(
        val id: Long,
        val title: String,
        val author: String
    ):BookCommand()

    data class Delete(
        val id: Long
    ):BookCommand()

    data class FindById(
        val id: Long
    ):BookCommand()
}