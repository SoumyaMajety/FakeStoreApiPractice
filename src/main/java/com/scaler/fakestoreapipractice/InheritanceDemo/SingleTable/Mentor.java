package com.scaler.fakestoreapipractice.InheritanceDemo.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "St_Mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User{
    String subject;
    double rating;
}
