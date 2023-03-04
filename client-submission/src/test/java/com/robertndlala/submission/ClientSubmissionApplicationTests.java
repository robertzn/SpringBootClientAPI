package com.robertndlala.submission;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robertndlala.submission.entity.ClientInfo;
import com.robertndlala.submission.repository.ClientRepository;
import com.robertndlala.submission.service.ClientService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@TestPropertySource("/application.properties")
@AutoConfigureMockMvc
@SpringBootTest
class ClientSubmissionApplicationTests {

	private static MockHttpServletRequest request;
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository ClientRepository;


	private ClientInfo[] ClientInfos = new ClientInfo[] {
			new ClientInfo("1", "Jon", "Ndlala",  "12345678912", "123456789785214"),

	};
/*

	@Test
	public void getClientByIdTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/client/1");
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(ClientInfo().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.count").value(ClientInfos[0].getCount()))
				.andExpect(jsonPath("$.first_name").value(ClientInfos[0].getFirst_name()));
				.andExpect(jsonPath("$.Moblie").value(ClientInfos[0].getMobile()));
				.andExpect(jsonPath("$.first_name").value(ClientInfos[0].getFirst_name()));
	}

	private void andExpect(RequestMatcher value) {
	}

	/*Long count, String first_name, String last_name, lon01574852
	g Moblie, Long idnumber*/






}


