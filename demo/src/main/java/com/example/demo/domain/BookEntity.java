package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Table(name = "Books")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {

    @Id
    private String isbn;
    private String title;


    @JoinColumn(name = "author_id")
    @ManyToOne(cascade = CascadeType.ALL)
    @Autowired
    private AuthorEntity author;
}
