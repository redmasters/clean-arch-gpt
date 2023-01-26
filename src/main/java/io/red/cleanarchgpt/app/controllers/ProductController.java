package io.red.cleanarchgpt.app.controllers;

import io.red.cleanarchgpt.app.controllers.requests.AddToCardRequest;
import io.red.cleanarchgpt.core.usecases.UseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/v1/store")
public class ProductController {

    private final UseCase useCase;

    public ProductController(UseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody AddToCardRequest request){
        useCase.addToCart(request);
        return new ResponseEntity<>("Item added to cart", HttpStatus.OK);
    }
}
