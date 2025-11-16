package com.medibridge.backend.service;

import com.medibridge.backend.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment acknowledgeAppointment(Long id, String status);

    List<Appointment> getAppointmentsByDoctor(Long doctorId);
    List<Appointment> getAppointmentsByPatient(Long patientId);
}
