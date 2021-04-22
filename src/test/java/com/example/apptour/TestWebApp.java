package com.example.apptour;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebApp extends ApptourApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test // Only get products JPA
	public void testgetProdutcs() throws Exception {
		mockMvc.perform(get("/api/v1/products")).andExpect(status().isOk());

	}

	@Test // With pagination and default const
	public void testgetProdutcsPage() throws Exception {
		mockMvc.perform(get("/api/v1/products/p")).andExpect(status().isOk());

	}

}
