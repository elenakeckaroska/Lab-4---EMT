package com.example.doctorpatient.patient.services.impl;

import com.example.doctorpatient.patient.domain.exceptions.PatientNotFoundException;
import com.example.doctorpatient.patient.domain.form.PatientForm;
import com.example.doctorpatient.patient.domain.model.Patient;
import com.example.doctorpatient.patient.domain.model.PatientId;
import com.example.doctorpatient.patient.domain.repository.PatientRepository;
import com.example.doctorpatient.patient.services.PatientService;
import com.example.doctorpatient.patient.xport.event.NewPatientInHospital;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Patient findById(PatientId id) {
        return patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
    }

    @Override
    public Patient insertPatient(PatientForm form) {
        Patient p = Patient.build(form.getPersonalData());
        patientRepository.saveAndFlush(p);
        applicationEventPublisher.publishEvent(new NewPatientInHospital(p));
        return p;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
