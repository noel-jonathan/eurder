package com.eurder.customers;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.eurder.TestConstants.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestHTTPEndpoint(CustomerController.class)
class CustomerControllerTest {

    @Test
    void createCustomer_givenIncompleteRequest_thenShouldReturn400() {
        CreateCustomerDto incompleteCreateCustomerDto = new CreateCustomerDto(
                CREATE_CUSTOMER_DTO.firstName(),
                CREATE_CUSTOMER_DTO.lastName(),
                CREATE_CUSTOMER_DTO.email(),
                CREATE_CUSTOMER_DTO.address(),
                null
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(incompleteCreateCustomerDto)
                .when().post()
                .then().statusCode(400);
        assertEquals(0, Customer.listAll().size());
    }

    @Test
    void whenCreateCustomer_thenShouldReturn201() {

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(CREATE_CUSTOMER_DTO)
                .when().post()
                .then().statusCode(201);
        assertEquals(1, Customer.listAll().size());
    }

    @Test
    void getAll() {
        given()
                .when().get()
                .then().statusCode(200);
    }

    @Test
    void whenGetCustomer_givenWrongId_thenShouldReturn404() {
        Long id = 1234567879L;

        given()
                .pathParam("id", id)
                .when().get("/{id}")
                .then().statusCode(404);
    }

    @Test
    void whenGetCustomer_givenCustomer_thenShouldReturn200() {

        Integer id = given()
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
    @Transactional
    void tearDown() {
        Customer.deleteAll();
    }
}
