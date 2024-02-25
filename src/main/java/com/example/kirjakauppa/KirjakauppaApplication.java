package com.example.kirjakauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kirjakauppa.domain.BookRepository;
import com.example.kirjakauppa.domain.book;

@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			book a = new book("max", "max", 1, 2, 3);
			book c = new book("max", "max", 1, 2, 3);
			book d = new book("max", "max", 1, 2, 3);

			bookRepository.save(d);
			bookRepository.save(a);
			bookRepository.save(c);

		};
	}
}