package org.example.hexagonalarchitecture.books.domain.ports;

import org.example.hexagonalarchitecture.books.domain.model.Book;

public interface BookRepository {
	Book save(Long authorId, String title, String content);

	Book get(Long bookId);
}
