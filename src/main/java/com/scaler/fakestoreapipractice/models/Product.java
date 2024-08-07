package com.scaler.fakestoreapipractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel {

    String title;
    double price;
    @ManyToOne
    Category category;
    String description;
    String image;

}
