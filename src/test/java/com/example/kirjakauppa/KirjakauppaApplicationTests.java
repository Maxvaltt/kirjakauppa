package com.example.kirjakauppa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.kirjakauppa.domain.BookController;
import com.example.kirjakauppa.domain.BookRepository;
import com.example.kirjakauppa.domain.BookRestController;
import com.example.kirjakauppa.domain.Category;
import com.example.kirjakauppa.domain.CategoryController;
import com.example.kirjakauppa.domain.CategoryRepository;
import com.example.kirjakauppa.domain.User;
import com.example.kirjakauppa.domain.UserRepository;
import com.example.kirjakauppa.domain.book;


@SpringBootTest
class KirjakauppaApplicationTests {

	@Autowired
	private BookController controllerbook;

	@Autowired
	private BookRestController controllerbookrest;

	@Autowired
	private CategoryController controllercategory;

	@Autowired
	private BookRepository repositorybook;

	@Autowired
	private CategoryRepository repositorycategory;

	@Autowired
	private UserRepository repositoryuser;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controllerbook).isNotNull();
	}

	@Test
	public void contextLoads2() throws Exception {
		assertThat(controllerbookrest).isNotNull();
	}

	@Test
	public void contextLoads3() throws Exception {
		assertThat(controllercategory).isNotNull();
	}


	@Test
	public void findByAuthorShouldReturnBook() {
	   List<book> books = repositorybook.findByAuthor("max");
	   assertThat(books).hasSize(3);
	   assertThat(books.get(0).getAuthor()).isEqualTo("max");
	}

	@Test
	 public void createNewBook() {
		book book = new book("Maailman matka", "mic", 2007, 1444, 69, null);
	   repositorybook.save(book);
	   assertThat(book.getId()).isNotNull();
	 }

   @Test
	public void doesCategoryExistById() {
	   Optional<Category> categories = repositorycategory.findById(2L);
	   assertThat(categories).isPresent();
	}

	@Test
	public void createNewUser() {
	   User user = new User("max", "maxonparas", "ADMIN");
	   repositoryuser.save(user);
	   assertThat(user.getId()).isNotNull();		
	}
}
