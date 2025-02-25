package com.example.demo.UnitTests;


import com.example.demo.Dtos.AuthorDto;
import com.example.demo.Repos.AuthorRepo;
import com.example.demo.Services.AuthorService;
import com.example.demo.domain.AuthorEntity;
import com.example.demo.mappers.AuthorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepo authorRepo;

    @Mock
    private AuthorMapper authorMapper;

    @BeforeEach
    private void setUp(){
    }


    @Test
    public void testCreateAuthorIsCalledWithRightArguments(){
        AuthorDto testAuthorDto= AuthorDto.builder()
                .age(23)
                .name("john")
                .id(1L)
                .build();
        AuthorEntity testAuthorEntity= AuthorEntity.builder()
                .age(23)
                .name("john")
                .id(1L)
                .build();

        Mockito.when(authorMapper.mapTo(testAuthorDto)).thenReturn(testAuthorEntity);

        authorService.createAuthor(testAuthorDto);

        Mockito.verify(authorRepo).save(testAuthorEntity);
    }

}
