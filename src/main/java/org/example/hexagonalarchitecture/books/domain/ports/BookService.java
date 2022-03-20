package org.example.hexagonalarchitecture.books.domain.ports;

import lombok.AllArgsConstructor;
import org.example.hexagonalarchitecture.books.domain.model.Book;

@AllArgsConstructor
public class BookService {

	private final BookRepository bookRepository;

	public Long create(Long authorId, String title, String content) {
		Book book = bookRepository.save(authorId, title, content);
		return book.getId();
	}

}
