package com.scaler.fakestoreapipractice.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "St_Student")
@DiscriminatorValue(value = "1")
public class Student extends User{
    String batch;
    double psp;
}
