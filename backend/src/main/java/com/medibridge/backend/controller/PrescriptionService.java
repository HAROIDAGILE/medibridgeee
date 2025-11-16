package com.medibridge.backend.service.impl;
import com.medibridge.backend.entity.Prescription;
import java.util.List;
import java.util.Optional;

public interface PrescriptionService {

    Prescription createPrescription(Prescription prescription);

    Optional<Prescription> getPrescriptionById(Long id);

    List<Prescription> getAllPrescriptions();

    List<Prescription> getPrescriptionsByPatientId(Long patientId);
}
