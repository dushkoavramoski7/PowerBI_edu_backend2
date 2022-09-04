package com.example.powerbi_edu_backend2.Model.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Influencers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String fullName;
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @ElementCollection
    private List<String> channels;

    public Influencers(String fullName, String description, List<String> channels) {
        this.fullName = fullName;
        this.description = description;
        this.channels = channels;
    }


    public Influencers() {
    }
}
