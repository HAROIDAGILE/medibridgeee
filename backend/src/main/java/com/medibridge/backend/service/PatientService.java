package com.medibridge.backend.service;
import com.medibridge.backend.entity.Patient;
import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    List<Patient> getAllPatients();
}
