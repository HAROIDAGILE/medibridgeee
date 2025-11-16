package com.medibridge.backend.controller;

import com.medibridge.backend.dto.PatientRecordRequest;
import com.medibridge.backend.dto.PatientRecordResponse;
import com.medibridge.backend.service.impl.PatientRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-records")
public class PatientRecordController {

    private final PatientRecordService service;

    public PatientRecordController(PatientRecordService service) {
        this.service = service;
    }

    // ✅ Create new record
    @PostMapping
    public ResponseEntity<PatientRecordResponse> createRecord(@RequestBody PatientRecordRequest request) {
        return ResponseEntity.ok(service.createRecord(request));
    }

    // ✅ Get record by ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientRecordResponse> getRecord(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecord(id));
    }

    // ✅ Get all records for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<PatientRecordResponse>> getRecordsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.getRecordsByPatient(patientId));
    }

    // ✅ Update record
    @PutMapping("/{id}")
    public ResponseEntity<PatientRecordResponse> updateRecord(
            @PathVariable Long id,
            @RequestBody PatientRecordRequest request) {
        return ResponseEntity.ok(service.updateRecord(id, request));
    }

    // ✅ Delete record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}

