package com.eurder.orders;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.mock;

@QuarkusTest
@TestHTTPEndpoint(OrderController.class)
class OrderControllerTest {

//    @Test
//    void createOrder_givenIncompleteRequest_thenShouldReturn400() {
//
//        CreateOrderDto incomplete = mock(CreateOrderDto.class);
//
//        given()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(incomplete)
//                .when().post()
//                .then().statusCode(400);
//    }

}