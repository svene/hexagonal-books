package org.example.hexagonalarchitecture.books.adapters.primary.http;

import lombok.AllArgsConstructor;
import org.example.hexagonalarchitecture.books.domain.ports.BookService;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BooksFacade {

	private final BookService service;

	public BookIdResponse create(BookRequest bookRequest) {
		Long bookId = service.create(bookRequest.authorId(), bookRequest.getTitle(), bookRequest.getContent());
		return BookIdResponse.of(bookId);
	}
}
