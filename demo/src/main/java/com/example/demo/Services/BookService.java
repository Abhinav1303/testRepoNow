package com.example.demo.Services;

import com.example.demo.Dtos.BookDto;
import com.example.demo.Repos.BookRepo;
import com.example.demo.domain.BookEntity;
import com.example.demo.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookService {

    @Autowired
    private final BookRepo bookRepo;

    @Autowired
    private final BookMapper bookMapper;


    public BookService(BookRepo bookRepo, BookMapper bookMapper) {
        this.bookRepo = bookRepo;
        this.bookMapper=bookMapper;
    }

    BookEntity createBook(BookDto bookDto){
        BookEntity bookEntity=bookMapper.mapTo(bookDto);
        bookRepo.save(bookEntity);
        return bookEntity;
    }
}
