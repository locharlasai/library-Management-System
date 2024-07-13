package com.library.service;

import com.library.entity.Book;

import java.util.List;

public interface LibraryManagement {

    String addBook(Book book);

    String removeBook(String ISBN);


    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByAuthor(String author);


    List<Book> listAllBooks();

    List<Book> listAvailableBooks();


}
