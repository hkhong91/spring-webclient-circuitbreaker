package com.example.circuitbreaker.application.model;

import com.example.circuitbreaker.domain.data.Product;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {

  private final String id;
  private final String name;
  private final String description;
  private final int price;
  private final int stock;
  private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  public static ProductResponse of(Product product) {
    return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .stock(product.getStock())
        .createdAt(product.getCreatedAt())
        .updatedAt(product.getUpdatedAt())
        .build();
  }
}
