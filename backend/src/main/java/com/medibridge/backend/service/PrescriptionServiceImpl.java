package com.medibridge.backend.service.impl;
import com.medibridge.backend.entity.Prescription;
import com.medibridge.backend.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Spring will automatically detect this concrete implementation
public class PrescriptionServiceImpl implements PrescriptionService { // Implements the new interface

    private final PrescriptionRepository prescriptionRepository;

    // Dependency Injection via constructor
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    /**
     * Saves a new prescription to the database.
     *
     * @param prescription The prescription object to save.
     * @return The saved prescription object.
     */
    @Override
    public Prescription createPrescription(Prescription prescription) {
        // Here you could add validation, e.g., checking if the patientId exists
        if (prescription.getDurationDays() <= 0) {
            throw new IllegalArgumentException("Prescription duration must be greater than zero.");
        }
        return prescriptionRepository.save(prescription);
    }

    /**
     * Retrieves a prescription by its ID.
     *
     * @param id The ID of the prescription.
     * @return An Optional containing the Prescription if found, or empty otherwise.
     */
    @Override
    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    /**
     * Retrieves all prescriptions.
     *
     * @return A list of all prescriptions.
     */
    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    /**
     * Retrieves all prescriptions for a specific patient.
     *
     * @param patientId The ID of the patient.
     * @return A list of prescriptions for the given patient.
     */
    @Override
    public List<Prescription> getPrescriptionsByPatientId(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }
}