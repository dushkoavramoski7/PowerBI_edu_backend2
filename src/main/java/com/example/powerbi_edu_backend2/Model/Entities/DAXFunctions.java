package com.example.powerbi_edu_backend2.Model.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class DAXFunctions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String syntax;

    @ElementCollection
    private List<String> parameters;

    private String returnValue;

    private String category;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    public DAXFunctions() {
    }

    public DAXFunctions(String syntax, List<String> parameters, String returnValue, String category, String description) {
        this.syntax = syntax;
        this.parameters = parameters;
        this.returnValue = returnValue;
        this.category = category;
        this.description = description;
    }
}
