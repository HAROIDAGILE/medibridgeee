package com.medibridge.backend.dto;
import com.medibridge.backend.entity.Prescription;
import com.medibridge.backend.entity.MedicalHistory;
import java.util.List;
import java.time.LocalDateTime;

// DTO (Data Transfer Object) for combining Medical History and its related Prescriptions for the API response.
public class MedicalHistoryDTO {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private String doctorsNote;
    private LocalDateTime visitDate;
    private List<Prescription> prescriptions; // List of associated prescriptions

    // Constructor to map the MedicalHistory entity and attach the list of Prescriptions
    public MedicalHistoryDTO(MedicalHistory history, List<Prescription> prescriptions) {
        this.id = history.getId();
        this.patientId = history.getPatientId();
        this.doctorId = history.getDoctorId();
        this.doctorsNote = history.getDoctorsNote();
        this.visitDate = history.getVisitDate();
        this.prescriptions = prescriptions;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
    public String getDoctorsNote() { return doctorsNote; }
    public void setDoctorsNote(String doctorsNote) { this.doctorsNote = doctorsNote; }
    public LocalDateTime getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDateTime visitDate) { this.visitDate = visitDate; }
    public List<Prescription> getPrescriptions() { return prescriptions; }
    public void setPrescriptions(List<Prescription> prescriptions) { this.prescriptions = prescriptions; }
}
