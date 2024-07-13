package com.library.mappers;

import com.library.entity.Book;
import com.library.model.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mappings({
            @Mapping(target = "ISBN", source = "isbn"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "author", source = "author"),
            @Mapping(target = "genre", source = "genre"),
            @Mapping(target = "publicationYear", source = "publicationYear"),
            @Mapping(target = "department", source = "department"),
            @Mapping(target = "available", source = "available")
    })
    Book bookRequestToBook(BookRequest bookRequest);
}