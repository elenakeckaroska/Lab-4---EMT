package com.example.appointment.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObjectInterface;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;

@Getter
public class Patient implements ValueObjectInterface {

    @Column(name = "patientId")

    private final PatientId id;

    private final PersonalData personalData;

    @JsonCreator
    public Patient(@JsonProperty("patientId") PatientId id,
                   @JsonProperty("personalData") PersonalData personalData) {
        this.id = id;
        this.personalData = personalData;
    }

    public Patient(PersonalData personalData){
        this.id = PatientId.randomId(PatientId.class);
        this.personalData = personalData;
    }
}
