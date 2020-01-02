package com.learningstuff.rediscachingspringboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২/১/২০
 * Time: ৯:১৫ AM
 * Email: mdshamim723@gmail.com
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private LocalDate createdAt;

    @PrePersist
    public void perPersist() {
        createdAt = LocalDate.now();
    }

}
