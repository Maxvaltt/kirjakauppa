package com.example.kirjakauppa.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<book, Long> {

}
