package com.medibridge.backend.entity;;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Note: Assuming your Patient entity has a Long ID.
// In a real application, you might use @ManyToOne to link to the Patient entity itself.

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to the Patient (via ID from your existing Patient API)
    // *** Updated to explicitly use the column name 'patient_id' ***
    @Column(name = "patient_id")
    private Long patientId;

    private String medicineName;
    private String dosage; // e.g., "5mg, once daily"
    private int durationDays; // The number of days the prescription is valid for

    // Constructors
    public Prescription() {
    }

    public Prescription(Long patientId, String medicineName, String dosage, int durationDays) {
        this.patientId = patientId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.durationDays = durationDays;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", durationDays=" + durationDays +
                '}';
    }
}
