package com.scaler.fakestoreapipractice.dtos;

import lombok.Data;

@Data
public class FakeStoreProductResponseDto {
    int id;
    String title;
    double price;
    String category;
    String description;
    String image;
}
