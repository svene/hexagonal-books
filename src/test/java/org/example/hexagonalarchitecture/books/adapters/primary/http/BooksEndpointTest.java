package org.example.hexagonalarchitecture.books.adapters.primary.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hexagonalarchitecture.books.adapters.repository.InMemoryBookRepository;
import org.example.hexagonalarchitecture.books.domain.ports.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BooksEndpoint.class)
@ContextConfiguration(classes = {BooksEndpoint.class, BooksFacade.class, BookService.class, InMemoryBookRepository.class})
class BooksEndpointTest {

	@Autowired
	private MockMvc mockMvc;

	private String createRequestBody = """
		{
			"title": "myTitle",
			"content": "book content",
			"authorId": 200
		}
		""";

	@Test
	void testDeserialization() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(createRequestBody, BookRequest.class);
	}

	@Test
	void createBook() throws Exception {
		String expectedJsonResponse = """
    		{
				"id": 1
    		}
			""";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/books")
					.contentType(MediaType.APPLICATION_JSON)
					.content(createRequestBody)
					.accept(MediaType.APPLICATION_JSON)
			)
//			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(content().json(expectedJsonResponse))
		;
	}

}
