package org.example.hexagonalarchitecture.books.adapters.primary.http;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import org.example.hexagonalarchitecture.books.domain.model.AuthorId;
import org.example.hexagonalarchitecture.books.domain.model.Book;

@Value
@Builder(access = AccessLevel.PACKAGE)
class BookResponse {
	private Long id;
	private AuthorId authorId;
	private String title;
	private String content;

	static BookResponse of(Book book) {
		return builder()
			.id(book.getId())
			.authorId(book.getAuthorId())
			.title(book.getTitle())
			.content(book.getContent())
			.build();
	}
}
