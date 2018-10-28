package com.thoughtworks.nho.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String title;

    String description;

    public Training(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
