package com.medibridge.backend.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public record PatientRecordResponse(
        Long id,
        Long patientId,
        String doctorRemarks,
//        Map<String, Object> patientDataJson,
        String patientDataJson,
        LocalDate recordedOn,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

