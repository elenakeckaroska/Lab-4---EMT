package com.example.doctorpatient.doctor.services.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class DoctorForm {
    @NotNull
    private PersonalData personalData;

    @NotNull
    private LocalDate workExperience;

    @Valid
    @NotEmpty
    private List<IsDoctorRelationForm> patients = new ArrayList<>();
}
