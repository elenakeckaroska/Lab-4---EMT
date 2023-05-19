package com.example.doctorpatient.patient.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;

import jakarta.persistence.*;


@Entity
@Table(name = "patients")
@Getter
public class Patient extends AbstractEntity<PatientId> {

    @AttributeOverrides({
            @AttributeOverride(name="name", column = @Column(name="patient_names")),
            @AttributeOverride(name="surname", column = @Column(name="patient_surname")),
            @AttributeOverride(name="dateOfBirth", column = @Column(name="patient_dateOfBirth")),


    })
    private PersonalData personalData;


    public Patient() {
        super(PatientId.randomId(PatientId.class));
    }
    public Patient(PersonalData personalData) {
        super(PatientId.randomId(PatientId.class));
        this.personalData = personalData;
    }
    public static Patient build(PersonalData data){
        Patient p =new Patient();
        p.personalData = data;

        return p;
    }
}
