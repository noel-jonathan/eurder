package com.eurder.orders;

import org.jboss.logging.Logger;

public record CreateOrderDto(Long customerId, Long itemId, int amount) {
    private static Logger logger = Logger.getLogger(CreateOrderDto.class);
    public CreateOrderDto {
        if (customerId == null || itemId == null) {
            String errorMessage = "customer id and item id cannot be null or empty";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
