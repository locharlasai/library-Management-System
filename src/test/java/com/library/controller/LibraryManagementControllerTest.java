package com.library.controller;

import com.library.entity.Book;
import com.library.mappers.BookMapper;
import com.library.model.ApiResponse;
import com.library.model.BookRequest;
import com.library.service.LibraryManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

public class LibraryManagementControllerTest {

    @Mock
    private LibraryManagement libraryService;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private LibraryManagementController libraryManagementController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBook() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setIsbn("978-0132350884");
        bookRequest.setTitle("Clean Code");
        bookRequest.setAuthor("Robert C. Martin");
        bookRequest.setGenre("Software Engineering");
        bookRequest.setPublicationYear(2008);
        bookRequest.setDepartment("Computer Science");
        bookRequest.setAvailable(true);

        Book mockBook = new Book();
        mockBook.setISBN("978-0132350884");
        mockBook.setTitle("Clean Code");
        mockBook.setAuthor("Robert C. Martin");
        mockBook.setGenre("Software Engineering");
        mockBook.setPublicationYear(2008);
        mockBook.setDepartment("Computer Science");
        mockBook.setAvailable(true);

        when(bookMapper.bookRequestToBook(bookRequest)).thenReturn(mockBook);

        BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "bookRequest");

        ResponseEntity<String> responseEntity = libraryManagementController.addBook(bookRequest, bindingResult);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        verify(libraryService).addBook(mockBook);
    }


    @Test
    public void testFindBooksByTitle() {
        String title = "Clean Code";
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());

        when(libraryService.findBooksByTitle(title)).thenReturn(mockBooks);

        ResponseEntity<ApiResponse> responseEntity = libraryManagementController.findBooksByTitle(title);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(libraryService).findBooksByTitle(title);
    }

    @Test
    public void testRemoveBook() {
        String isbn = "978-0132350884";
        String responseMessage = "Book removed successfully";

        when(libraryService.removeBook(isbn)).thenReturn(responseMessage);

        ResponseEntity<String> responseEntity = libraryManagementController.removeBook(isbn);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseMessage, responseEntity.getBody());

        verify(libraryService).removeBook(isbn);
    }

    @Test
    public void testFindBooksByAuthor() {
        String author = "Robert C. Martin";
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());

        when(libraryService.findBooksByAuthor(author)).thenReturn(mockBooks);

        ResponseEntity<ApiResponse> responseEntity = libraryManagementController.findBooksByAuthor(author);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(libraryService).findBooksByAuthor(author);
    }

    @Test
    public void testListAllBooks() {
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());

        when(libraryService.listAllBooks()).thenReturn(mockBooks);

        ResponseEntity<List<Book>> responseEntity = libraryManagementController.listAllBooks();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBooks, responseEntity.getBody());

        verify(libraryService).listAllBooks();
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> mockBooks = Arrays.asList(new Book(), new Book());

        when(libraryService.listAvailableBooks()).thenReturn(mockBooks);

        ResponseEntity<List<Book>> responseEntity = libraryManagementController.listAvailableBooks();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBooks, responseEntity.getBody());

        verify(libraryService).listAvailableBooks();
    }
}