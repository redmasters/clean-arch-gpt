package io.red.cleanarchgpt.core.usecases;

import io.red.cleanarchgpt.app.controllers.responses.ProductResponse;
import io.red.cleanarchgpt.core.entities.Product;
import io.red.cleanarchgpt.core.gateway.ProductGateway;
import org.springframework.stereotype.Service;

@Service
public class ListProductUseCase implements ProductUseCase{
    private final ProductGateway productGateway;

    public ListProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductResponse findById(Long id) {
        return productGateway.findById(id);
    }
}
