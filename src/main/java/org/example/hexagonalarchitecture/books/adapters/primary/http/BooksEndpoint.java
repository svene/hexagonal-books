package org.example.hexagonalarchitecture.books.adapters.primary.http;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BooksEndpoint {

	private final BooksFacade facade;

	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<BookIdResponse> create(
		@RequestBody BookRequest bookRequest
	) {
		BookIdResponse result = facade.create(bookRequest);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
