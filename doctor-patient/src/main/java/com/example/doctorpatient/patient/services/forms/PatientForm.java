package com.example.doctorpatient.patient.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;

@Data
public class PatientForm {
    private PersonalData personalData;
    private String embg;
}
