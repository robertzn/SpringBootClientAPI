
package com.robertndlala.submission;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class ClientControllerTest {

    private static MockHttpServletRequest request;

    @PersistenceContext
    private EntityManager entityManager;

    @Mock
    StudentAndGradeService studentCreateServiceMock;

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private ClientInfo clientInfo;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Value("${sql.script.create.student}")
    private String sqlAddClient;

    public static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;

    @BeforeAll
    public static void setup() {

        request = new MockHttpServletRequest();

        request.setParameter("first_name", "Robert");

        request.setParameter("last_name", "Ndlala");

        request.setParameter("IdNumber", "1234567896587");
        request.setParameter("Mobile", "1478542369");
    }

    @BeforeEach
    public void setupDatabase() {
        jdbc.execute(sqlAddClient);
    }

    @Test
    public void getClientHttpRequest() throws Exception {

        ClientInfo.setFirst_name("Robert");
        ClientInfo.setLast_name("Ndlala");
        ClientInfo.setMobile("0154785425");
        ClientInfo.setMobile("145874856955285");x
        entityManager.persist(clinet);
        entityManager.flush();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)));

    }


    @Test
    public void deleteClientService() {

        Optional<Client> deletedClient = client.findById(1);

        assertTrue(deletedClient.isPresent(), "return true");

        clientService.deleteClient(1);

        deletedClient = ClientR.findById(1);

        assertFalse(deletedClient.isPresent(), "return false");
        a
    }

    @Test
    public void createClienttHttpRequest() throws Exception {
        ClientInfo.setFirst_name("Robert");
        ClientInfo.setLast_name("Ndlala");
        ClientInfo.setMobile("0154785425");
        ClientInfo.setMobile("145874856955285");
        ClientInfo.setA("Home");

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Client)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        CollegeClient verifyClient = ClientInfo.findByEmailAddress("Idnumber");
        assertNotNull(verifyStudent, "client should be valid.");
    }

}
