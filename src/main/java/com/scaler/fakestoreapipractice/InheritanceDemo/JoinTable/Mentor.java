package com.scaler.fakestoreapipractice.InheritanceDemo.JoinTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "Jt_Mentor")
public class Mentor extends User{
    /*
    Id in user(base) class acts as primary key for this.
    It also acts as foreign key i.e mentor table will not have
    separate ID other than user id
    but id you want separate IDs for user and mentor,
    we can give one more attribute and mark it as primaryKeyJoinColumn

     */
    @PrimaryKeyJoinColumn
    int Mentorid;
    String subject;
    double rating;
}
