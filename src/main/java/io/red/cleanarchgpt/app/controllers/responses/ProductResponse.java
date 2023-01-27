package io.red.cleanarchgpt.app.controllers.responses;

import io.red.cleanarchgpt.core.entities.Product;

public record ProductResponse(
        Long id,
        String name,
        double price
) {
    public Product toEntity() {
        return new Product(id, name, price);
    }
}
