package com.example.demo.Repos;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class BooksRepoIntegrationTest {

    private final BookRepo bookRepo;

    @Autowired
    public BooksRepoIntegrationTest(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

//    @Test
//    void testBookCreateAndRecall(){
//        AuthorEntity author= AuthorEntity.builder()
//                .id(2L)
//                .age(23)
//                .name("Abigail Rose")
//                .build();
//
//        BookEntity bookEntity = BookEntity.builder()
//                .isbn("Isbn1")
//                .title("Harry Potter")
//                .author(author)
//                .build();
//        bookRepo.save(bookEntity);
//        Optional<BookEntity> returnedBook=bookRepo.findById(bookEntity.getIsbn());
//        assert(returnedBook).isPresent();
//        assert(returnedBook.get()).equals(bookEntity);
//
//    }
    @Test
    void testDeleteAll(){
        bookRepo.deleteAll();
    }
}
