package com.example.doctorpatient.patient.domain.repository;

import com.example.doctorpatient.patient.domain.model.Patient;
import com.example.doctorpatient.patient.domain.model.PatientId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, PatientId> {
}
