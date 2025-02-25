package com.example.demo.Repos;

import com.example.demo.Dtos.AuthorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTest {
    private AuthorRepo undertest;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper;
    @Autowired
    public AuthorControllerIntegrationTest(AuthorRepo authorRepo, MockMvc mockMvc, ObjectMapper objectMapper){

        this.undertest=authorRepo;
        this.mockMvc=mockMvc;
        this.objectMapper=objectMapper;
    }
    @Test
    public void TestAuthorCreateAuthor() throws Exception {
        AuthorDto authorDto = AuthorDto.builder()
                .name("FirstAuthor")
                .id(27L)
                .age(23)
                .build();
        String authorJson = objectMapper.writeValueAsString(authorDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(authorJson)

        ).andExpect(MockMvcResultMatchers.status().isCreated());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("FirstAuthor"));
    }

//    @Test
//    public void testDeleteAuthor(){
//        undertest.deleteById(1L);
//        assertFalse(undertest.findById(1L).isPresent());
//    }
//    @Test
//    public void testDeleteAllAuthor(){
//        undertest.deleteAll();
//        assert StreamSupport.stream(undertest.findAll().spliterator(), false).count() == 0;
//
//
//    }
//    @Test
//    public void testCustomQuery(){
//        AuthorEntity authorA= AuthorEntity.builder()
//                .id(1L)
//                .name("John")
//                .age(23)
//                .build();
//        AuthorEntity authorB= AuthorEntity.builder()
//                .id(2L)
//                .name("Abigail Rose")
//                .age(23)
//                .build();
//
//        Iterable<AuthorEntity> listOfAuthors=undertest.returnsAuthorsAgeGreaterThanCertainAge(10,15);
//        assertThat(listOfAuthors).containsExactly(authorA,authorB);
//    }






}
