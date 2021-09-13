package com.example.circuitbreaker.application.controller;

import com.example.circuitbreaker.application.model.ProductResponse;
import com.example.circuitbreaker.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("")
  public Flux<ProductResponse> getProducts() {
    return productService.getProducts();
  }
}
