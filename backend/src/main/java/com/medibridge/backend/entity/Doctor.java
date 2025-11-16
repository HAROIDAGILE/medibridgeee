package com.medibridge.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String gender;
    private int yoe;  // Years of experience
    private String degree;
    private String specialization;
    private String profilePicture; // will store image URL or file name

    public Doctor() {}

    public Doctor(String name, String email, String password, String gender, int yoe, String degree, String specialization, String profilePicture) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.yoe = yoe;
        this.degree = degree;
        this.specialization = specialization;
        this.profilePicture = profilePicture;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getYoe() { return yoe; }
    public void setYoe(int yoe) { this.yoe = yoe; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
}
