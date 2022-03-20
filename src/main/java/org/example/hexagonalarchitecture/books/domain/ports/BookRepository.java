package org.example.hexagonalarchitecture.books.domain.ports;

import org.example.hexagonalarchitecture.books.domain.model.Book;

public interface BookRepository {
	public Book save(Long authorId, String title, String content);
}
