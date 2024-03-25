package com.example.kirjakauppa.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestController
public interface CategoryRepository extends CrudRepository<Category, Long> {

    
}
