package org.example.hexagonalarchitecture.books.adapters.primary.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.hexagonalarchitecture.books.domain.model.AuthorId;

@Getter
public class BookRequest {
	private final String title;
	private final String content;
	private final Long authorId;

	public BookRequest(
		@JsonProperty("title") String title,
		@JsonProperty("content") String content,
		@JsonProperty("authorId") Long authorId
	) {
		this.title = title;
		this.content = content;
		this.authorId = authorId;
	}

	public AuthorId authorId() {
		return AuthorId.of(authorId);
	}
}
