package com.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Libraries")
public class Book {

    @Id
    private String ISBN;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private String department;
    private boolean available;
}
