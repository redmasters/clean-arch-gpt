package io.red.cleanarchgpt.core.usecases;

import io.red.cleanarchgpt.app.controllers.requests.AddToCardRequest;

public interface CartUseCase {
    void addToCart(AddToCardRequest request);

}
