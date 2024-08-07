package com.scaler.fakestoreapipractice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    Date createdAt;
    Date updatedAt;
}
