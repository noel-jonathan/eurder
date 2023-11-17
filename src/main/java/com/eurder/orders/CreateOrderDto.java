package com.eurder.orders;

import org.jboss.logging.Logger;

public record CreateOrderDto(Long itemId, int amount) {
    private static Logger logger = Logger.getLogger(CreateOrderDto.class);
    public CreateOrderDto {
        if (itemId == null) {
            String errorMessage = "Item id cannot be null or empty";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        if (amount < 1) {
            String errorMessage = "Amount must be at least one";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
