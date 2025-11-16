package com.medibridge.backend.controller;
import com.medibridge.backend.entity.Doctor;
import com.medibridge.backend.repository.DoctorRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
}
