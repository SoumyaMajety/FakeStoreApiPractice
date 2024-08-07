package com.scaler.fakestoreapipractice.InheritanceDemo.TablePerClass;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "TBC_User")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
     here Identity type is not supported for Generated value
     use GenerationType.TABLE or GenerationType.SEQUENCE
             */
    int id;
    String email;
    String PhNo;
    String password;
}
