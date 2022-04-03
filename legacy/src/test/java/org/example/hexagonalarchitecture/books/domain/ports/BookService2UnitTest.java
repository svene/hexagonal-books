package org.example.hexagonalarchitecture.books.domain.ports;

import org.example.hexagonalarchitecture.books.domain.model.AuthorId;
import org.example.hexagonalarchitecture.books.domain.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Like BookService1UnitTest but using Spring's @MockBean and @Autowired instead of Mockitos @Mock and @InjectMocks
 */
@ExtendWith(SpringExtension.class)
class BookService2UnitTest {

	public static final AuthorId AUTHOR_ID = AuthorId.of(200L);
	public static final long BOOK_ID = 99L;

	@MockBean
	BookRepository repository;

	@Autowired
	BookService service;

	@Test
	void repositorySaveCalled() {
		System.out.println(System.identityHashCode(repository));
		when(repository.save(any(AuthorId.class), anyString(), anyString())).thenReturn(
			Book.builder().id(BOOK_ID).build()
		);
		service.create(AUTHOR_ID, "title", "content");
		verify(repository, times(1)).save(AUTHOR_ID, "title", "content");
	}

	@Test
	void createReturnsIdOfRepositorySave() {
		when(repository.save(any(AuthorId.class), anyString(), anyString())).thenReturn(
			Book.builder().id(99L).authorId(AuthorId.of(2L)).title("testTitle").content("testContent").build()
		);

		Long id = service.create(AUTHOR_ID, "title", "content");
		assertThat(id).isEqualTo(BOOK_ID);
	}

	@Test
	void getCallsRepository() {
		when(repository.get(anyLong())).thenReturn(
			Book.builder().id(BOOK_ID).build()
		);
		service.get(BOOK_ID);
		verify(repository, times(1)).get(BOOK_ID);
	}

	@Configuration
	static class TestConfiguration {

		@Autowired
		BookRepository repository;

		@Bean
		BookService service() {
			return new BookService(repository);
		}

	}
}
