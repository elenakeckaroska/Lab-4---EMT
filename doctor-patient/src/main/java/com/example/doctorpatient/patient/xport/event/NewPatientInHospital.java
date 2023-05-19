package com.example.doctorpatient.patient.xport.event;

import com.example.doctorpatient.patient.domain.model.Patient;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.LocalDateTime;

@Getter
public class NewPatientInHospital extends ApplicationEvent {
    private LocalDateTime when;
    private Patient patient;


    public NewPatientInHospital(Patient source, LocalDateTime when) {
        super(source);
        this.patient = source;
        this.when = when;
    }

    public NewPatientInHospital(Patient source) {
        super(source);
        this.when = LocalDateTime.now();
        this.patient = source;
    }


}
