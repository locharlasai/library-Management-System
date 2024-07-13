package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibraryRepository extends MongoRepository<Book, String> {

    Book findByISBNAndDepartment(String ISBN, String department);

    List<Book> findByTitleIgnoreCase(String title);

    List<Book> findByAuthorIgnoreCase(String author);

    List<Book> findByAvailableTrue();


}
