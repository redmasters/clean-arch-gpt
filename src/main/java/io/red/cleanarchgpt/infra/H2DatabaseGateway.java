package io.red.cleanarchgpt.infra;

import io.red.cleanarchgpt.app.controllers.responses.ProductResponse;
import io.red.cleanarchgpt.core.entities.Cart;
import io.red.cleanarchgpt.core.entities.Product;
import io.red.cleanarchgpt.core.exceptions.ProductNotFoundException;
import io.red.cleanarchgpt.core.gateway.ProductGateway;
import io.red.cleanarchgpt.infra.repositories.CartJpaRepository;
import io.red.cleanarchgpt.infra.repositories.ProductJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class H2DatabaseGateway implements ProductGateway {
    private final ProductJpaRepository productJpaRepository;
    private final CartJpaRepository cartJpaRepository;

    public H2DatabaseGateway(ProductJpaRepository productJpaRepository, CartJpaRepository cartJpaRepository) {
        this.productJpaRepository = productJpaRepository;
        this.cartJpaRepository = cartJpaRepository;
    }

    @Override
    public ProductResponse findById(Long id) {
        Product product = productJpaRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Invalid Product ID"));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    @Override
    public void saveCart(Cart cart) {
        productJpaRepository.saveAll(cart.getItems());
        cartJpaRepository.save(cart);
    }

}
