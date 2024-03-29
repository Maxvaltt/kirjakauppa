package com.example.kirjakauppa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BookRepository extends CrudRepository<book, Long> {
    List<book> findByAuthor(@Param("author") String author);
}
