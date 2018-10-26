package com.example.demo_jpa.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Setter
@Getter
public class Role implements Serializable {
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
}
