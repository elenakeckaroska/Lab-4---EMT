package com.example.doctorpatient.patient.services;

import com.example.doctorpatient.patient.domain.form.PatientForm;
import com.example.doctorpatient.patient.domain.model.Patient;
import com.example.doctorpatient.patient.domain.model.PatientId;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
    Patient findById(PatientId id);
    Patient insertPatient(PatientForm form);
    List<Patient> getAll();
}
