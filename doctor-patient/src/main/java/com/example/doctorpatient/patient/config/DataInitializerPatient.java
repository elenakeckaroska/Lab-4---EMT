package com.example.doctorpatient.patient.config;

import com.example.doctorpatient.patient.domain.model.Patient;
import com.example.doctorpatient.patient.domain.repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializerPatient {
    private final PatientRepository patientRepository;

    @PostConstruct
    public void initData(){
        Patient patient1 = Patient.build(PersonalData.valueOf("patient1", "patient1", LocalDate.of(2001,8,1),"0108001"));

        Patient patient2 = Patient.build(PersonalData.valueOf("patient2", "patient2", LocalDate.of(2001,8,1),"0108001"));


        if(patientRepository.findAll().isEmpty()){
            patientRepository.saveAllAndFlush(Arrays.asList(patient1, patient2));
        }
    }
}
