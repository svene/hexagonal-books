package org.example.hexagonalarchitecture.books;

import org.example.hexagonalarchitecture.books.adapters.repository.InMemoryBookRepository;
import org.example.hexagonalarchitecture.books.domain.model.AuthorId;
import org.example.hexagonalarchitecture.books.domain.model.Book;
import org.example.hexagonalarchitecture.books.domain.ports.BookRepository;
import org.example.hexagonalarchitecture.books.domain.ports.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import(BookService1IntegrationTest.TestConfiguration.class)
class BookService1IntegrationTest {

	public static final AuthorId AUTHOR_ID = AuthorId.of(200L);

	@Autowired
	BookRepository repository;

	@Autowired
	BookService service;

	@Test
	void createReturnsIdOfRepositorySave() {
		Long bookId = service.create(AUTHOR_ID, "title", "content");
		assertThat(bookId).isEqualTo(1L);
	}

	@Test
	void getAfterSave() {
		Long bookId = service.create(AUTHOR_ID, "title", "content");
		Book actual = service.get(bookId);
		assertThat(actual).isEqualTo(
			Book.builder().id(bookId).authorId(AUTHOR_ID).title("title").content("content").build()
		);
	}

	@Configuration
	static class TestConfiguration {

		@Bean
		BookRepository repository() {
			return new InMemoryBookRepository();
		}

		@Bean
		BookService service() {
			return new BookService(repository());
		}

	}
}
