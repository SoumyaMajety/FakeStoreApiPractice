package com.scaler.fakestoreapipractice.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "TBC_Student")
public class Student extends User{
    String batch;
    double psp;
}
