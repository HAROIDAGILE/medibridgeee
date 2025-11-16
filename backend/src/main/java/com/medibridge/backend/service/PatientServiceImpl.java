package com.medibridge.backend.service;

import com.medibridge.backend.entity.Patient;
import com.medibridge.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
}
