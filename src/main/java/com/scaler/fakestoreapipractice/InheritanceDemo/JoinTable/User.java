package com.scaler.fakestoreapipractice.InheritanceDemo.JoinTable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Jt_User")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String email;
    String PhNo;
    String password;
}
