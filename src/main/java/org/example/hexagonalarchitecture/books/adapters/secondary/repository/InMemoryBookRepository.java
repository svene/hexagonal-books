package org.example.hexagonalarchitecture.books.adapters.secondary.repository;

import org.example.hexagonalarchitecture.books.domain.model.AuthorId;
import org.example.hexagonalarchitecture.books.domain.model.Book;
import org.example.hexagonalarchitecture.books.domain.ports.BookRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * in-memory variant of a 'BookRepository'
 * This class is intended to be used for Integration Tests and
 * for application use with mock mode enabled
 */
@Component
public class InMemoryBookRepository implements BookRepository {

	AtomicLong idCounter = new AtomicLong(1);
	Map<Long, Book> storage = new HashMap<>();

	@Override
	public Book save(AuthorId authorId, String title, String content) {
		Book book = Book.builder()
			.id(idCounter.getAndIncrement())
			.authorId(authorId)
			.title(title)
			.content(content)
			.build();
		storage.put(book.getId(), book);
		return book;
	}

	@Override
	public Book get(Long bookId) {
		return storage.get(bookId);
	}

	public void clear() {
		this.storage.clear();
		idCounter.set(1);
	}
}
