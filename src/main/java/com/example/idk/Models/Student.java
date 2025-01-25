package com.example.idk.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import jakarta.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @Min(value = 0, message = "Grade must be a positive number")
    private double grade;
//     Getter for 'id'
    public int getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'grade'
    public double getGrade() {
        return grade;
    }

    // Setter for 'grade'
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
