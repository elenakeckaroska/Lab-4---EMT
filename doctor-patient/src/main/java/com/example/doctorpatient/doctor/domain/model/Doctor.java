package com.example.doctorpatient.doctor.domain.model;

import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "doctors")
@Getter
public class Doctor extends AbstractEntity<DoctorId> {

    @AttributeOverrides({
            @AttributeOverride(name="name", column = @Column(name="doctor_names")),
            @AttributeOverride(name="surname", column = @Column(name="doctor_surname")),
            @AttributeOverride(name="dateOfBirth", column = @Column(name="doctor_dateOfBirth")),

    })
    private PersonalData personalData;

    private LocalDate workExperience;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IsDoctorRelation> patients = new ArrayList<>();

    public Doctor(){
        super(DoctorId.randomId(DoctorId.class));

    }
    public Doctor(PersonalData personalData, LocalDate workExperience){
        super(DoctorId.randomId(DoctorId.class));
        this.workExperience = workExperience;
        this.personalData = personalData;
    }
    public static Doctor build(PersonalData data, LocalDate workExperience){
        Doctor doctor = new Doctor();
        doctor.personalData = data;
        doctor.workExperience = workExperience;

        return doctor;
    }

    public IsDoctorRelation addPatient(@NonNull Patient patient){
        Objects.requireNonNull(patient, "patient must not be null");
        var p = new IsDoctorRelation(patient.getId(),patient.getPersonalData());

        patients.add(p);
        return p;
    }
}
