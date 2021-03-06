package com.example.circuitbreaker.application.service;

import com.example.circuitbreaker.application.model.ProductResponse;
import com.example.circuitbreaker.domain.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductClient productClient;

  public Flux<ProductResponse> getProducts() {
    return productClient.getProducts()
        .map(ProductResponse::of);
  }

  public Mono<ProductResponse> getProduct(String productId) {
    return productClient.getProduct(productId)
        .map(ProductResponse::of);
  }
}
