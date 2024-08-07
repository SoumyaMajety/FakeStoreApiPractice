package com.scaler.fakestoreapipractice.InheritanceDemo.SingleTable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "St_User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String email;
    String PhNo;
    String password;
}
