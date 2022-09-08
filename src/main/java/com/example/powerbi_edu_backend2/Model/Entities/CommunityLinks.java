package com.example.powerbi_edu_backend2.Model.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
public class CommunityLinks {
    private static final String DATE_FORMATTER= "yyyy-MM-dd";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String description;

    private String url;

    private LocalDateTime uploadedTime;

    private Boolean shared;

    public CommunityLinks(String name, String description, String url, LocalDateTime uploadedTime, Boolean shared) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.uploadedTime = uploadedTime;
        this.shared = shared;
    }

    public CommunityLinks() {
    }

    public String getFormattedLinkShared() {
        return "Shared: " + DateTimeFormatter.ofPattern(DATE_FORMATTER).format(this.uploadedTime) + ", "+ this.uploadedTime.getDayOfWeek();
    }
}
