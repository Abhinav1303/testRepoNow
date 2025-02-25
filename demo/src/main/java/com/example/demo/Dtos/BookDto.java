package com.example.demo.Dtos;

import com.example.demo.domain.AuthorEntity;
import lombok.Builder;

@Builder
public class BookDto {
    private String isbn;
    private String title;
    private AuthorEntity author;
}
