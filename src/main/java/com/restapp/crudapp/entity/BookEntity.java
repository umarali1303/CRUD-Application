package com.restapp.crudapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;
}
