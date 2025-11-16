package com.medibridge.backend.dto;

import java.time.LocalDate;
import java.util.Map;

public record PatientRecordRequest(
        Long patientId,
        String doctorRemarks,
        Map<String, Object> patientDataJson, // height, weight, blood pressure
        LocalDate recordedOn
)
{}


