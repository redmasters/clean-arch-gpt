package io.red.cleanarchgpt.core.gateway;

import io.red.cleanarchgpt.core.entities.Cart;
import io.red.cleanarchgpt.core.entities.Product;

public interface ProductGateway {
    Product findById(Long id);

    void saveCart(Cart cart);
}
