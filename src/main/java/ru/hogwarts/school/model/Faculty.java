package ru.hogwarts.school.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String color;

    @OneToMany (mappedBy = "faculty")
    private Set<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
