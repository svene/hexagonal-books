package org.example.hexagonalarchitecture.books.adapters.http;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
class BooksEndpoint {

	private final BooksFacade facade;

	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	ResponseEntity<BookIdResponse> create(
		@RequestBody BookRequest bookRequest
	) {
		BookIdResponse result = facade.create(bookRequest);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping(value = "{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<BookResponse> get(@PathVariable("bookId") final Long bookId) {
		BookResponse result = facade.get(bookId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
