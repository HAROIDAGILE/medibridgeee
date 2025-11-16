package com.medibridge.backend.controller;
import com.medibridge.backend.entity.MedicalHistory;
import com.medibridge.backend.dto.MedicalHistoryDTO;
import com.medibridge.backend.service.impl.MedicalHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-history") // Base path for this API
public class MedicalHistoryController {

    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    // POST /api/medical-history
    @PostMapping
    public ResponseEntity<MedicalHistory> createMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        try {
            MedicalHistory newRecord = medicalHistoryService.createMedicalHistory(medicalHistory);
            return new ResponseEntity<>(newRecord, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // GET /api/medical-history/{id} - Get a single record with its associated prescriptions
    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistoryDTO> getMedicalHistoryById(@PathVariable Long id) {
        return medicalHistoryService.getMedicalHistoryById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET /api/medical-history/patient/{patientId} - Get all records (history + prescriptions) for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalHistoryDTO>> getMedicalHistoryByPatientId(@PathVariable Long patientId) {
        List<MedicalHistoryDTO> records = medicalHistoryService.getMedicalHistoryByPatientId(patientId);
        if (records.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
}


