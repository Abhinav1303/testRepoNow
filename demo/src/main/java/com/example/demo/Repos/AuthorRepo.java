package com.example.demo.Repos;

import com.example.demo.domain.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {

//    @Query("Select a from Author a where a.age>?1 and a.age>?2")
//    Iterable<AuthorEntity> returnsAuthorsAgeGreaterThanCertainAge(int i, int j);

}
