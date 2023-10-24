package com.eurder.customers;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(CustomerController.class)
//@TestProfile(TestCustomerServiceProfile.class)
class CustomerControllerTest {
    @Test
    void whenCreateCustomer_thenShouldReturnSuccessfully() {
        CreateCustomerDto createCustomerDto = new CreateCustomerDto(
                "John",
                "Doe",
                "<EMAIL>",
                "Address",
                "123456789"
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createCustomerDto)
                .when().post()
                .then().statusCode(200);
    }
}
