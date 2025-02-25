package com.example.demo;


import com.example.demo.Repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Runner {
    @Autowired
    private AuthorRepo authorRepo;

    public Runner(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    void runner(){
        deleteAuthor();
    }
    void createAuthor(){

    }
    void deleteAuthor(){
        authorRepo.deleteById(3L);

    }
}