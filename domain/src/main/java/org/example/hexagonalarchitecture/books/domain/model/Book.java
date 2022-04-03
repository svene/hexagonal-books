package org.example.hexagonalarchitecture.books.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Book {
	Long id;
	AuthorId authorId;
	String title;
	String content;
}
