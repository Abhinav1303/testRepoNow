package com.example.demo;

import com.example.demo.Dtos.AuthorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestClasses {

    private final ObjectMapper objectMapper;

    @Autowired
    public TestClasses(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void createJsonRequestBodyFromObject() throws Exception{
        AuthorDto authorDto=AuthorDto.builder()
                .id(2L)
                .name("LatestCreationNow")
                .age(23)
                .build();
        System.out.println(objectMapper.writeValueAsString(authorDto));;
    }
}
