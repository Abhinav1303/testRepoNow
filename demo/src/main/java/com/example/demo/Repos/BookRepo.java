package com.example.demo.Repos;


import com.example.demo.domain.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<BookEntity,String> {

}
