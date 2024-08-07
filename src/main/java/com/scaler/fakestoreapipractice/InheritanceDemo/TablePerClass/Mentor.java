package com.scaler.fakestoreapipractice.InheritanceDemo.TablePerClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "TBC_Mentor")
public class Mentor extends User {
    String subject;
    double rating;
}
