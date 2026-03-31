package com.example.demo.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

public class EmployeeApiSteps {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private ResponseEntity<String> response;

    @When("I request employee with id {long}")
    public void iRequestEmployeeWithId(long id) {
        String url = "http://localhost:" + port + "/employees/" + id;
        response = restTemplate.getForEntity(url, String.class);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertThat(response.getStatusCode().value()).isEqualTo(statusCode);
    }

    @And("the employee id should be {long}")
    public void theEmployeeIdShouldBe(long id) throws IOException {
        JsonNode json = objectMapper.readTree(response.getBody());
        assertThat(json.get("id").asLong()).isEqualTo(id);
    }

    @And("the employee name should be {string}")
    public void theEmployeeNameShouldBe(String name) throws IOException {
        JsonNode json = objectMapper.readTree(response.getBody());
        assertThat(json.get("name").asText()).isEqualTo(name);
    }
}
