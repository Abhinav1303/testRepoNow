package com.example.demo.Controllers;

import com.example.demo.Dtos.AuthorDto;
import com.example.demo.Repos.AuthorRepo;
import com.example.demo.Services.AuthorService;
import com.example.demo.domain.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    private final AuthorRepo authorRepo;

    public AuthorController(AuthorService authorService, AuthorRepo authorRepo) {
        this.authorService = authorService;
        this.authorRepo = authorRepo;
    }


    //    @PostMapping(path = "authors/{id}")
//    public AuthorEntity createSingleAuthor(@PathVariable("id") Long id){
//
//        AuthorDto authorDto=AuthorDto.builder()
//                .id(id)
//                .age(23)
//                .name("NameFromRest")
//                .build();
//
//        return authorService.createAuthor(authorDto);
//
//    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorEntity> createSingleAuthor(@RequestBody AuthorDto authorDto){

        return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/authors/{id}")
    public AuthorEntity getSingleAuthorById(@PathVariable("id") Long id){
        return authorService.getAuthorById(id);
    }

}
