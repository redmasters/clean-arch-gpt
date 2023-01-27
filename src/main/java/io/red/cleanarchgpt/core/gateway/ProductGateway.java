package io.red.cleanarchgpt.core.gateway;

import io.red.cleanarchgpt.app.controllers.responses.ProductResponse;
import io.red.cleanarchgpt.core.entities.Cart;
import io.red.cleanarchgpt.core.entities.Product;

public interface ProductGateway {
    ProductResponse findById(Long id);

    void saveCart(Cart cart);
}
