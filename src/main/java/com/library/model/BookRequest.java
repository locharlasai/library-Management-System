package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NonNull
@NoArgsConstructor
public class BookRequest {

    @NotBlank(message = "isbn cannot be blank")
    private String isbn;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotBlank(message = "Genre cannot be blank")
    private String genre;

    @PositiveOrZero(message = "Publication year must be a positive or zero number")
    private int publicationYear;

    @NotBlank(message = "Department cannot be blank")
    private String department;

    @NotNull(message = "Availability must be specified")
    private Boolean available;
}
