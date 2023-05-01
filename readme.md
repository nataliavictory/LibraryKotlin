# Library

RESTful API for managing a library.

### Description

This is a project for a RESTful API that allows you to manage a library. The API allows you to create, list, update and delete books from the library.


### How to run the project

To run the project, you need to have Java and Gradle installed. Then, just clone the repository, access the project directory and run the command:


This will download the project dependencies and run the application on port 8080.

### How to use the API

The API has the following endpoints:

- `POST /v1/api/books`:  creates a new book in the library.
- `PUT /v1/api/books/{id}`:  creates a new book in the library.
- `DELETE /v1/api/books/{id}`:  deletes a book from the library.
- `GET /v1/api/books/{id}`: searches for a book in the library by ID.
- `GET /v1/api/books`:  lists all books in the library.

The POST and PUT endpoints receive a JSON payload with the book information. The GET /v1/api/books endpoint returns a list of books in JSON format.

Below is an example of JSON payload to create or update a book:

<pre>
{  
    "title": "Dom Quixote",  
    "author": "Miguel de Cervantes"  
}
</pre>



## Technologies used

The project was developed using the following technologies:

- Java 17
- Spring Boot 2.7.11
- Gradle
- Jackson
- JUnit 5

## Author

Desenvolvido por Natália Victory.
