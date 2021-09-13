package com.example.circuitbreaker.domain.client;

import com.example.circuitbreaker.domain.data.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ProductClient {

  private final WebClient webClient;

  public Flux<Product> getProducts() {
    return webClient.get()
        .uri("/products")
        .retrieve()
        .bodyToFlux(Product.class);
  }
}
