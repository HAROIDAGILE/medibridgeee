package com.medibridge.backend.service;

import com.medibridge.backend.entity.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
}
