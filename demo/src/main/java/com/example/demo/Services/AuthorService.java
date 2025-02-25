package com.example.demo.Services;

import com.example.demo.Dtos.AuthorDto;
import com.example.demo.Repos.AuthorRepo;
import com.example.demo.domain.AuthorEntity;
import com.example.demo.mappers.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private final AuthorRepo authorRepo;

    @Autowired
    private final AuthorMapper authorMapper;


    public AuthorService(AuthorRepo authorRepo, AuthorMapper authorMapper) {
        this.authorRepo = authorRepo;
        this.authorMapper =authorMapper;
    }

    public AuthorEntity createAuthor(AuthorDto authorDto){
        AuthorEntity authorEntity= authorMapper.mapTo(authorDto);
        return authorRepo.save(authorEntity);
    }

    public AuthorEntity getAuthorById(Long id) {
        if(authorRepo.findById(id).isPresent()) {
            return authorRepo.findById(id).get();
        }
        return null;
    }
}