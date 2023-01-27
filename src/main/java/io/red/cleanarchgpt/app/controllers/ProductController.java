package io.red.cleanarchgpt.app.controllers;

import io.red.cleanarchgpt.app.controllers.requests.AddToCardRequest;
import io.red.cleanarchgpt.app.controllers.responses.ProductResponse;
import io.red.cleanarchgpt.core.usecases.CartUseCase;
import io.red.cleanarchgpt.core.usecases.ProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/v1/store")
public class ProductController {

    private final CartUseCase cartUseCase;
    private final ProductUseCase productUseCase;

    public ProductController(CartUseCase cartUseCase, ProductUseCase productUseCase) {
        this.cartUseCase = cartUseCase;
        this.productUseCase = productUseCase;
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody AddToCardRequest request){
        cartUseCase.addToCart(request);
        return new ResponseEntity<>("Item added to cart", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> findProduct(@PathVariable Long id){
        return new ResponseEntity<>(productUseCase.findById(id), HttpStatus.OK);
    }
}
