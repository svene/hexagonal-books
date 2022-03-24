package org.example.hexagonalarchitecture.books.adapters.primary.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class BookIdResponse {
	private final Long id;

	private BookIdResponse(Long id) {
		this.id = id;
	}

	@JsonProperty("id")
	Long id() {
		return id;
	}

	static BookIdResponse of(Long id) {
		return new BookIdResponse(id);
	}
}
