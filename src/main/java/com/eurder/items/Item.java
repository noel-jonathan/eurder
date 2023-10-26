package com.eurder.items;

import org.jboss.logging.Logger;

import java.util.UUID;

public class Item {
    private static Logger logger = Logger.getLogger(Item.class);
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private int stock;

    public Item(String name, String description, double price, int stock) {
        this.id = String.valueOf(UUID.randomUUID().toString());
        this.name = validate("Name", name);
        this.description = validate("Description", description);
        this.price = validate("Price", price);
        this.stock = validate("Quantity", stock);
    }

    public String validate(String fieldName, String string) {
        if (string == null || string.isEmpty()) {
            String errorMessage = fieldName + " not filled in";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return string;
    }

    public double validate(String fieldName, double price) {
        if (price <= 0) {
            String errorMessage = "Invalid " + fieldName;
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return price;
    }

    public int validate(String fieldName, int quantity) {
        if (quantity <= 0) {
            String errorMessage = "Invalid " + fieldName;
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        return quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
