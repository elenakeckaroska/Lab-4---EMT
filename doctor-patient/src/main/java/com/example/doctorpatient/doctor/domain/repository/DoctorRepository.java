package com.example.doctorpatient.doctor.domain.repository;

import com.example.doctorpatient.doctor.domain.model.Doctor;
import com.example.doctorpatient.doctor.domain.model.DoctorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, DoctorId> {
    public Doctor findByPersonalDataName(String name);
}
