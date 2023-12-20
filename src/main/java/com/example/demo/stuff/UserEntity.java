package com.example.demo.stuff;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "demo")
@Accessors(chain = true)
public class UserEntity {

    @Id
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
}
