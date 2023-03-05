package com.robertndlala.submission;
import ch.qos.logback.core.net.server.Client;
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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestPropertySource("/application.properties")

@SpringBootTest


class ClientSubmissionApplicationTests {

	private JdbcTemplate jdbc;


	private ClientInfo clientInfo;

	private   ClientService clientService;

	@Value("${sql.script.create.Client}")
	private String sqlAddClientInfo;

	@Value("${sql.script.delete.Client}")
	private String sqlDeleteClientInfo;


	@BeforeEach
	public void setupDatabase() {
		jdbc.execute(sqlAddClientInfo);
	}



	@Test
	public void deleteClientInfoService() {
		Optional<Client> deleteClient = clientInfo.findById(1);

		assertFalse(deleteClient.isPresent(), "return false");

	}




}


