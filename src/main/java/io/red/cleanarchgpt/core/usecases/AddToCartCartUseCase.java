package io.red.cleanarchgpt.core.usecases;

import io.red.cleanarchgpt.app.controllers.requests.AddToCardRequest;
import io.red.cleanarchgpt.app.controllers.responses.ProductResponse;
import io.red.cleanarchgpt.core.entities.Cart;
import io.red.cleanarchgpt.core.entities.Product;
import io.red.cleanarchgpt.core.exceptions.ProductNotFoundException;
import io.red.cleanarchgpt.core.gateway.ProductGateway;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddToCartCartUseCase implements CartUseCase {
    private final ProductGateway productGateway;

    public AddToCartCartUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void addToCart(AddToCardRequest request) {
        List<Product> listProduct = new ArrayList<>();

        ProductResponse productResponse = productGateway
                .findById(request.productId());

        if (productResponse == null) {
            throw new ProductNotFoundException("Invalid Product ID");
        }

        listProduct.add(new Product(
                        productResponse.id(),
                        productResponse.name(),
                        productResponse.price()
                )
        );

        Cart cart = new Cart(
                request.userId(),
                listProduct
        );

        productGateway.saveCart(cart);

    }


}
