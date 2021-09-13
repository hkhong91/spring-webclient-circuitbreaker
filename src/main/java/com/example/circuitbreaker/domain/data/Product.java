package com.example.circuitbreaker.domain.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Product {

  @JsonProperty("_id")
  private String id;
  private String name;
  private String description;
  private int price;
  private int stock;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
