package com.example.circuitbreaker.application.controller;

import com.example.circuitbreaker.application.model.ProductResponse;
import com.example.circuitbreaker.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("")
  public Flux<ProductResponse> getProducts() {
    return productService.getProducts();
  }

  @GetMapping("/{productId}")
  public Mono<ProductResponse> getProduct(@PathVariable String productId) {
    return productService.getProduct(productId);
  }
}
