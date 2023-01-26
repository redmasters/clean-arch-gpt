package io.red.cleanarchgpt.app.controllers.requests;

public record AddToCardRequest(
        Long productId,
        Long userId

) {
}
