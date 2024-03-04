package com.example.kirjakauppa;

import com.example.kirjakauppa.domain.Category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kirjakauppa.domain.BookRepository;
import com.example.kirjakauppa.domain.book;
import com.example.kirjakauppa.domain.CategoryRepository;


@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			// ...

			Category scifi = new Category("Scifi");
			Category comic = new Category("Comic");
			Category thriller = new Category("Thriller");
			Category fantasy = new Category("Fantasy");

			categoryRepository.save(scifi);
			categoryRepository.save(comic);
			categoryRepository.save(thriller);
			categoryRepository.save(fantasy);

			// ...

			book a = new book("max", "max", 1, 2, 3, thriller);
			book c = new book("max", "max", 1, 2, 3, scifi);
			book d = new book("max", "max", 1, 2, 3, fantasy);

			bookRepository.save(d);
			bookRepository.save(a);
			bookRepository.save(c);

		};
	}
}