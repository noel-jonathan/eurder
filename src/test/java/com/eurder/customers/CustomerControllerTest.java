package com.eurder.customers;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestHTTPEndpoint(CustomerController.class)
//@TestProfile(TestCustomerServiceProfile.class)
class CustomerControllerTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    void whenCreateCustomer_thenShouldReturn201() {

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(TestConstants.CREATE_CUSTOMER_DTO)
                .when().post()
                .then().statusCode(201);
        assertEquals(1, customerRepository.getCustomers().size());
    }

    @Test
    void createCustomer_givenIncompleteRequest_thenShouldReturn400() {
        CreateCustomerDto createCustomerDto = new CreateCustomerDto(
                "John",
                "",
                "<EMAIL>",
                "Address",
                "123456789"
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createCustomerDto)
                .when().post()
                .then().statusCode(400);
        assertEquals(0, customerRepository.getCustomers().size());
    }

    @Test
    void getAll() {
        given()
                .when().get()
                .then().statusCode(200);
    }

    @Test
    void whenGetCustomer_givenNoCustomer_thenShouldReturn404() {
        String id = "1111";

        given()
                .pathParam("id", id)
                .when().get("/{id}")
                .then().statusCode(404);
    }

    @Test
    void whenGetCustomer_givenCustomer_thenShouldReturn200() {
        CreateCustomerDto createCustomerDto = new CreateCustomerDto(
                "John",
                "Doe",
                "<EMAIL>",
                "Address",
                "123456789"
        );

        String id = given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createCustomerDto)
                .when().post()
                .then().statusCode(201)
                .extract()
                .path("id");

        given()
                .pathParam("id", id)
                .when().get("/{id}")
                .then().statusCode(200);
    }

}
