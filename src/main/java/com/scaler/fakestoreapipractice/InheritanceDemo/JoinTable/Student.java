package com.scaler.fakestoreapipractice.InheritanceDemo.JoinTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "Jt_Student")

public class Student extends User {
    String batch;
    double psp;
}
