package com.example.doctorpatient.doctor.services.forms;

import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IsDoctorRelationForm {

    @NotNull
    private Patient patient;

    public IsDoctorRelationForm(Patient patient) {
        this.patient = patient;
    }
}
