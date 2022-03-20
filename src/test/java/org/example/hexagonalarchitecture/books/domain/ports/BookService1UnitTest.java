package org.example.hexagonalarchitecture.books.domain.ports;

import org.example.hexagonalarchitecture.books.domain.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookService1UnitTest {

	public static final long AUTHOR_ID = 200L;
	public static final long BOOK_ID = 99L;

	@Mock
	BookRepository repository;

	@InjectMocks
	BookService service;

	@Test
	void repositorySaveCalled() {
		when(repository.save(anyLong(), anyString(), anyString())).thenReturn(
			Book.builder().id(BOOK_ID).build()
		);
		service.create(AUTHOR_ID, "title", "content");
		verify(repository, times(1)).save(AUTHOR_ID, "title", "content");
	}

	@Test
	void createReturnsIdOfRepositorySave() {
		when(repository.save(anyLong(), anyString(), anyString())).thenReturn(
			Book.builder().id(99L).authorId(2L).title("testTitle").content("testContent").build()
		);

		Long id = service.create(AUTHOR_ID, "title", "content");
		assertThat(id).isEqualTo(BOOK_ID);
	}
}
