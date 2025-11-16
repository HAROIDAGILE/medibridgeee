package com.medibridge.backend.controller;
import com.medibridge.backend.entity.Prescription;
import com.medibridge.backend.service.impl.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions") // Base path for this API
public class PrescriptionController {

    // Injecting the Interface here (PrescriptionService) is the key!
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // POST /api/prescriptions
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        try {
            Prescription newPrescription = prescriptionService.createPrescription(prescription);
            return new ResponseEntity<>(newPrescription, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Handle validation errors gracefully
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // GET /api/prescriptions/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id)
                .map(prescription -> new ResponseEntity<>(prescription, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET /api/prescriptions - Get all
    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    // GET /api/prescriptions/patient/{patientId} - Get by Patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByPatientId(@PathVariable Long patientId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);
        if (prescriptions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }
}


