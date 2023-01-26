package io.red.cleanarchgpt.core.usecases;

import io.red.cleanarchgpt.app.controllers.requests.AddToCardRequest;
import io.red.cleanarchgpt.core.entities.Cart;
import io.red.cleanarchgpt.core.entities.Product;
import io.red.cleanarchgpt.core.exceptions.ProductNotFoundException;
import io.red.cleanarchgpt.core.gateway.ProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToCartUseCase implements UseCase{
    private final ProductGateway productGateway;

    public AddToCartUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }
    @Override
    public void addToCart(AddToCardRequest request) {
        Product product = productGateway.findById(request.productId());

        if(product == null) {
            throw new ProductNotFoundException("Invalid Product ID");
        }

        Cart cart = new Cart(request.userId());
        cart.addItem(product);

        productGateway.saveCart(cart);

    }
}
