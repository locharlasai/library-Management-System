package com.library.controller;


import com.library.entity.Book;
import com.library.mappers.BookMapper;
import com.library.model.ApiResponse;
import com.library.model.BookRequest;
import com.library.service.LibraryManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryManagementController {


    private final LibraryManagement libraryService;

    private final BookMapper bookMapper;

    @Autowired
    public LibraryManagementController(LibraryManagement libraryService, BookMapper bookMapper) {
        this.libraryService = libraryService;
        this.bookMapper = bookMapper;
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@Valid @RequestBody BookRequest bookRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid book data provided");
        }
        log.info("Received book request: {}", bookRequest.toString());
        Book book = bookMapper.bookRequestToBook(bookRequest);
        log.info("Mapped book entity: {}", book.toString());
        String addedBook = libraryService.addBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @GetMapping("/findBooksByTitle/{title}")
    public ResponseEntity<ApiResponse> findBooksByTitle(@PathVariable("title") String title) {
        log.info("api started for find books by title");
        List<Book> books = libraryService.findBooksByTitle(title);
        if (!books.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Books found", books), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse("No books found with the given title", null), HttpStatus.OK);
        }
    }


    @DeleteMapping("/removeBook/{isbn}")
    public ResponseEntity<String> removeBook(@PathVariable("isbn") String ISBN) {
        log.info("Api started for delete book by isbn id");
       String response= libraryService.removeBook(ISBN);
        log.info("successfully deleted the book");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/findBooksByAuthor/{author}")
    public ResponseEntity<ApiResponse> findBooksByAuthor(@PathVariable("author") String author) {
        log.info("api started for get book by author");
        List<Book> books = libraryService.findBooksByAuthor(author);
        if (!books.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Books found", books), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse("No books found with the given title", null), HttpStatus.OK);
        }
    }

    @GetMapping("/listAllBooks")
    public ResponseEntity<List<Book>> listAllBooks() {
        log.info("api started for get all the books in library");
        List<Book> books = libraryService.listAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/listAvailableBooks")
    public ResponseEntity<List<Book>> listAvailableBooks() {
        log.info("api started for get only available books in the library");
        List<Book> books = libraryService.listAvailableBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
