package org.example.hexagonalarchitecture.books.domain.ports;

import org.example.hexagonalarchitecture.books.domain.model.AuthorId;
import org.example.hexagonalarchitecture.books.domain.model.Book;

public interface BookRepository {
	Book save(AuthorId authorId, String title, String content);

	Book get(Long bookId);
}
