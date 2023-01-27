package io.red.cleanarchgpt.core.usecases;

import io.red.cleanarchgpt.app.controllers.responses.ProductResponse;

public interface ProductUseCase {
    ProductResponse findById(Long id);
}
