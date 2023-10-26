package com.eurder.items;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.eurder.TestConstants.ITEM_DTO;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(ItemController.class)
class ItemControllerTest {
    @Inject
    ItemRepository itemRepository;

    @Test
    void createItem_givenIncompleteRequest_thenShouldReturn400() {
        ItemDto incompleteCreateItemDto = new ItemDto(
                ITEM_DTO.id(),
                null,
                ITEM_DTO.description(),
                ITEM_DTO.price(),
                1
        );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(incompleteCreateItemDto)
                .when().post()
                .then().statusCode(400);
        assertEquals(0, itemRepository.getItems().size());
    }

    @Test
    void whenCreateItem_thenShouldReturn201() {

        given()
               .contentType(MediaType.APPLICATION_JSON)
               .body(ITEM_DTO)
               .when().post()
               .then().statusCode(201);
        assertEquals(1, itemRepository.getItems().size());
    }

    @Test
    void getAll() {
        given()
              .when().get()
              .then().statusCode(200);
    }

    @AfterEach
    void tearDown() {
        itemRepository.getItems().clear();
    }
}