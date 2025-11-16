package com.medibridge.backend.service.impl;

import com.medibridge.backend.dto.PatientRecordRequest;
import com.medibridge.backend.dto.PatientRecordResponse;

import java.util.List;

public interface PatientRecordService {
    PatientRecordResponse createRecord(PatientRecordRequest request);
    PatientRecordResponse getRecord(Long id);
    List<PatientRecordResponse> getRecordsByPatient(Long patientId);
    PatientRecordResponse updateRecord(Long id, PatientRecordRequest request);
    void deleteRecord(Long id);
}
