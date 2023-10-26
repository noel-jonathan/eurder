package com.eurder.orders;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@QuarkusTest
@TestHTTPEndpoint(OrderController.class)
class OrderControllerTest {

//    @Inject
//    OrderRepository orderRepository;

    @Test
    void createOrder_givenIncompleteRequest_thenShouldReturn400() {
        CreateOrderDto incompleteCreateOrderDto = mock(CreateOrderDto.class);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(incompleteCreateOrderDto)
                .when().post()
                .then().statusCode(400);
    }
}