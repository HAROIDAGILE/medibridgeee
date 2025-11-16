package com.medibridge.backend.service.impl;

import com.medibridge.backend.dto.PatientRecordRequest;
import com.medibridge.backend.dto.PatientRecordResponse;
import com.medibridge.backend.entity.Patient;
import com.medibridge.backend.entity.PatientRecord;
import com.medibridge.backend.repository.PatientRecordRepository;
import com.medibridge.backend.repository.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PatientRecordServiceImpl implements PatientRecordService {

    @Autowired
    private PatientRecordRepository recordRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public PatientRecordResponse createRecord(PatientRecordRequest request) {
        Patient patient = patientRepository.findById(request.patientId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        PatientRecord record = new PatientRecord();
        record.setPatient(patient);
        record.setDoctorRemarks(request.doctorRemarks());

        try {
            System.out.println("test "+request.patientDataJson().toString());
        } catch (Exception e) {
            throw new RuntimeException("Invalid patient data JSON", e);
        }


        try {
            record.setPatientDataJson(request.patientDataJson().toString());
        } catch (Exception e) {
            throw new RuntimeException("Invalid patient data JSON", e);
        }

        record.setRecordedOn(request.recordedOn());
        record.setPatientDataJson(request.patientDataJson().toString());

        return toResponse(recordRepository.save(record));
    }

    @Override
    public PatientRecordResponse getRecord(Long id) {
        return recordRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Record not found"));
    }

    @Override
    public List<PatientRecordResponse> getRecordsByPatient(Long patientId) {
        return recordRepository.findByPatientId(patientId)
                .stream().map(this::toResponse).toList();
    }

    @Override
    public PatientRecordResponse updateRecord(Long id, PatientRecordRequest request) {
        PatientRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found"));

        record.setDoctorRemarks(request.doctorRemarks());
        try {
            record.setPatientDataJson(objectMapper.writeValueAsString(request.patientDataJson()));
        } catch (Exception e) {
            throw new RuntimeException("Invalid patient data JSON", e);
        }
        record.setRecordedOn(request.recordedOn());

        return toResponse(recordRepository.save(record));
    }

    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    private PatientRecordResponse toResponse(PatientRecord record) {
        try {
//            Map<String, Object> data = objectMapper.readValue(record.getPatientDataJson(), Map.class);
            return new PatientRecordResponse(
                    record.getId(),
                    record.getPatient().getId(),
                    record.getDoctorRemarks(),
                    record.getPatientDataJson(),
                    record.getRecordedOn(),
                    record.getCreatedAt(),
                    record.getUpdatedAt()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error parsing patient data JSON", e);
        }
    }
}

