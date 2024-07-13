package com.library.service;

import com.library.entity.Book;
import com.library.repository.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.BaseStream;

@Service
@Slf4j
public class LibraryManagementImpl implements LibraryManagement {


    @Autowired
    private LibraryRepository libraryRepository;

    public String addBook(Book book) {
        Book existingBook = libraryRepository.findByISBNAndDepartment(book.getISBN(), book.getDepartment());
        if (existingBook != null) {
            throw new IllegalArgumentException("Book with ISBN " + book.getISBN() + " already exists in department " + book.getDepartment());
        }
         libraryRepository.save(book);
        return "successfully added book into library";
    }

    @Override
    public String removeBook(String ISBN) {
        log.info("calling mongodb to get the data");
        libraryRepository.deleteById(ISBN);
        return "successfully deleted book";
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        log.info("calling mongodb to get the data");
        return libraryRepository.findByTitleIgnoreCase(title);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        log.info("calling mongodb to get the data");
        return libraryRepository.findByAuthorIgnoreCase(author);
    }

    @Override
    public List<Book> listAllBooks() {
        log.info("calling mongodb to get the data");
        return libraryRepository.findAll();
    }

    @Override
    public List<Book> listAvailableBooks() {
        log.info("calling mongodb to get the data");
        return libraryRepository.findByAvailableTrue();
    }


}
