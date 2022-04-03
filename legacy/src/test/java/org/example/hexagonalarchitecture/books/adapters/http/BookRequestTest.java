package org.example.hexagonalarchitecture.books.adapters.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BookRequestTest {

	@Test
	void exceptionForUnknownField() {
		String jsonString = """
   				{
   				  "bla":  "blabla"
   				}
			""";

		ObjectMapper om = new ObjectMapper();
		assertThatThrownBy(() -> om.readValue(jsonString, BookRequest.class))
			.isInstanceOf(UnrecognizedPropertyException.class)
			.hasMessageContaining("Unrecognized field \"bla\"");
	}

	@Test
	void justTitleExample() throws JsonProcessingException {
		String jsonString = """
   				{
   				  "title":  "some title"
   				}
			""";

		ObjectMapper om = new ObjectMapper();
		BookRequest bookRequest = om.readValue(jsonString, BookRequest.class);
		assertThat(bookRequest.getTitle()).isEqualTo("some title");
		assertThat(bookRequest.getAuthorId()).isNull();
		assertThat(bookRequest.getContent()).isNull();
	}
}
