package com.medibridge.backend.controller;
import com.medibridge.backend.entity.Patient;
import com.medibridge.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatient(){
        return patientService.getAllPatients();
    }
}
