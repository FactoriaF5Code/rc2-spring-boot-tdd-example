package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.persistence.Product;
import com.example.demo.persistence.ProductRepository;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

	@Autowired
	private MockMvc api;

	@Autowired
	private ProductRepository repository;

	@Test
	void returns_existing_products() throws Exception {

		// given
		repository.saveAll(List.of(
				new Product(1, "vaso", "19.30", "30"),
				new Product(2, "cuadro", "29.30", "10")));

		// when
		api.perform(get("/api/products"))
				// then
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[*]", hasSize(2)))
				.andExpect(jsonPath("$[0].name", equalTo("vaso")))
				.andExpect(jsonPath("$[0].price", equalTo("19.30")))
				.andExpect(jsonPath("$[0].quantity", equalTo("30")))
				.andExpect(jsonPath("$[1].name", equalTo("cuadro")))
				.andExpect(jsonPath("$[1].price", equalTo("29.30")))
				.andExpect(jsonPath("$[1].quantity", equalTo("10")));

	}

}
