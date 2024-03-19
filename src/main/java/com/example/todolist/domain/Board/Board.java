package com.example.todolist.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity
public class Board {
    @GeneratedValue
    @Id
    private Long id;
    @Column
    private String content;
}
