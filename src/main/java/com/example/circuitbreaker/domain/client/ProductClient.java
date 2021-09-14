package com.example.circuitbreaker.domain.client;

import com.example.circuitbreaker.domain.data.Product;
import com.example.circuitbreaker.domain.exception.ClientCustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductClient {

  private final WebClient webClient;

  @CircuitBreaker(name = "productsCircuitBreaker", fallbackMethod = "fallbackGetProducts")
  public Flux<Product> getProducts() {
    return webClient.get()
        .uri("/products")
        .retrieve()
        .bodyToFlux(Product.class);
  }

  @CircuitBreaker(name = "productCircuitBreaker", fallbackMethod = "fallbackGetProduct")
  public Mono<Product> getProduct(String productId) {
    return webClient.get()
        .uri("/products/{productId}", productId)
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
          throw new ClientCustomException();
        })
        .bodyToMono(Product.class);
  }

  public Flux<Product> fallbackGetProducts(Exception exception) {
    log.error(exception.getMessage(), exception);
    return Flux.empty();
  }

  public Mono<Product> fallbackGetProduct(Exception exception) {
    log.error(exception.getMessage(), exception);
    return Mono.empty();
  }
}
