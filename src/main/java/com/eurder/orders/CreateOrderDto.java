package com.eurder.orders;

import org.jboss.logging.Logger;

public record CreateOrderDto(String customerId, CreateOrderGroupDto orderGroup) {
    private static Logger logger = Logger.getLogger(CreateOrderDto.class);
    public CreateOrderDto {
        if (customerId == null || customerId.isEmpty() || orderGroup == null) {
            String errorMessage = "customerId and orderGroup cannot be null or empty";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
