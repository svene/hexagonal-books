package org.example.hexagonalarchitecture.books.domain.ports;

import lombok.AllArgsConstructor;
import org.example.hexagonalarchitecture.books.domain.model.AuthorId;
import org.example.hexagonalarchitecture.books.domain.model.Book;
import org.springframework.stereotype.Service;

/**
 * Inbound port
 */
@AllArgsConstructor
@Service
public class BookService {

	private final BookRepository bookRepository;

	public Long create(AuthorId authorId, String title, String content) {
		Book book = bookRepository.save(authorId, title, content);
		return book.getId();
	}

	public Book get(Long bookId) {
		return bookRepository.get(bookId);
	}

}
