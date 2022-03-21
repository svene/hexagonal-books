package org.example.hexagonalarchitecture.books.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class AuthorId {
	private final Long value;

	public static AuthorId of(Long in) {
		return new AuthorId(in);
	}
}
