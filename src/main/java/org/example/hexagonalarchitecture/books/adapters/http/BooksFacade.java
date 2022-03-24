package org.example.hexagonalarchitecture.books.adapters.http;

import lombok.AllArgsConstructor;
import org.example.hexagonalarchitecture.books.domain.model.Book;
import org.example.hexagonalarchitecture.books.domain.ports.BookService;
import org.springframework.stereotype.Component;

/**
 * Purpose of Facade: translate 'domain model' to 'api model' and vice versa
 */
@AllArgsConstructor
@Component
class BooksFacade {

	private final BookService service;

	BookIdResponse create(BookRequest bookRequest) {
		Long bookId = service.create(bookRequest.authorId(), bookRequest.getTitle(), bookRequest.getContent());
		return BookIdResponse.of(bookId);
	}

	BookResponse get(Long bookId) {
		Book book = service.get(bookId);
		return BookResponse.of(book);
	}
}
