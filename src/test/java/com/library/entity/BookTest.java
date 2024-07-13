package com.library.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void testGetISBN() {
        Book book = new Book();
        book.setISBN("978-0132350884");
        assertEquals("978-0132350884", book.getISBN());
    }

    @Test
    public void testGetTitle() {
        Book book = new Book();
        book.setTitle("Clean Code");
        assertEquals("Clean Code", book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        Book book = new Book();
        book.setAuthor("Robert C. Martin");
        assertEquals("Robert C. Martin", book.getAuthor());
    }

    @Test
    public void testGetGenre() {
        Book book = new Book();
        book.setGenre("Software Engineering");
        assertEquals("Software Engineering", book.getGenre());
    }

    @Test
    public void testGetPublicationYear() {
        Book book = new Book();
        book.setPublicationYear(2008);
        assertEquals(2008, book.getPublicationYear());
    }

    @Test
    public void testGetDepartment() {
        Book book = new Book();
        book.setDepartment("Computer Science");
        assertEquals("Computer Science", book.getDepartment());
    }

    @Test
    public void testIsAvailable() {
        Book book = new Book();
        book.setAvailable(true);
        assertEquals(true, book.isAvailable());
    }
}
