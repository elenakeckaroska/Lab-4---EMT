package com.example.doctorpatient.doctor.config;

import com.example.doctorpatient.doctor.domain.model.Doctor;
import com.example.doctorpatient.doctor.domain.repository.DoctorRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final DoctorRepository doctorRepository;

    @PostConstruct
    public void initData(){
        Doctor doctor1 = new Doctor(PersonalData.valueOf("doctor1", "doctor1", LocalDate.of(1970,8,1),"0108001"),
                LocalDate.of(2001,8,1));
        Doctor doctor2 = new Doctor(PersonalData.valueOf("doctor2", "doctor2", LocalDate.of(1970,8,1),"0108001"),
                LocalDate.of(2001,8,1));
        if(doctorRepository.findAll().isEmpty())
            doctorRepository.saveAllAndFlush(Arrays.asList(doctor1,doctor2));
    }
}
