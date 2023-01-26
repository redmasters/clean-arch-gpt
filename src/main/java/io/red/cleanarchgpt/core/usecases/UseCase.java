package io.red.cleanarchgpt.core.usecases;

import io.red.cleanarchgpt.app.controllers.requests.AddToCardRequest;

public interface UseCase {
    void addToCart(AddToCardRequest request);
}
