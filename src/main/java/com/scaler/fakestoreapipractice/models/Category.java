package com.scaler.fakestoreapipractice.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModel {

    String title;
}
