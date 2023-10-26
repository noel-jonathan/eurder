package com.eurder.orders;

import org.jboss.logging.Logger;

public record CreateOrderGroupDto (String itemId, int amount) {
    private static Logger logger = Logger.getLogger(CreateOrderGroupDto.class);

    public CreateOrderGroupDto {
        if (amount <= 0) {
            String errorMessage = "amount must be greater than 0";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        if (itemId.isEmpty()) {
            String errorMessage = "itemId cannot be null";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
    public static CreateOrderGroupDto of(String itemId, int amount) {
        return new CreateOrderGroupDto(itemId, amount);
    }
}
