package com.eurder.customers;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.eurder.customers.TestConstants.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestHTTPEndpoint(CustomerController.class)
class CustomerControllerTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    void createCustomer_givenIncompleteRequest_thenShouldReturn400() {
        CreateCustomerDto incompleteCreateCustomerDto = new CreateCustomerDto(
                CREATE_CUSTOMER_DTO.getFirstName(),
                CREATE_CUSTOMER_DTO.getLastName(),
                CREATE_CUSTOMER_DTO.getEmail(),
                CREATE_CUSTOMER_DTO.getAddress(),
                null
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(incompleteCreateCustomerDto)
                .when().post()
                .then().statusCode(400);
        assertEquals(0, customerRepository.getCustomers().size());
    }

    @Test
    void whenCreateCustomer_thenShouldReturn201() {

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CREATE_CUSTOMER_DTO)
                .when().post()
                .then().statusCode(201);
        assertEquals(1, customerRepository.getCustomers().size());
    }

    @Test
    void getAll() {
        given()
                .when().get()
                .then().statusCode(200);
    }

    @Test
    void whenGetCustomer_givenWrongId_thenShouldReturn404() {
        String id = UUID.randomUUID().toString();

        given()
                .pathParam("id", id)
                .when().get("/{id}")
                .then().statusCode(404);
    }

    @Test
    void whenGetCustomer_givenCustomer_thenShouldReturn200() {

        String id = given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CREATE_CUSTOMER_DTO)
                .when().post()
                .then().statusCode(201)
                .extract()
                .path("id");

        given()
                .pathParam("id", id)
                .when().get("/{id}")
                .then().statusCode(200);
    }

    @AfterEach
    void tearDown() {
        customerRepository.getCustomers().clear();
    }
}
