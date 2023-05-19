package com.example.appointment.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.ValueObjectInterface;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;

import java.time.Instant;
import java.time.LocalDate;

@Getter
public class Doctor implements ValueObjectInterface {

    @AttributeOverrides({
            @AttributeOverride(name="name", column = @Column(name="doctor_names")),
            @AttributeOverride(name="surname", column = @Column(name="doctor_surname")),
            @AttributeOverride(name="dateOfBirth", column = @Column(name="doctor_dateOfBirth")),

    })
    private final PersonalData personalData;

    private final LocalDate workExperience;

    private final DoctorId id;

    private Doctor(){
        this.id = DoctorId.randomId(DoctorId.class);
        this.personalData = PersonalData.valueOf("","",LocalDate.now(),"");
        this.workExperience = LocalDate.now();

    }
    @JsonCreator
    public  Doctor(@JsonProperty("id") DoctorId id,
                   @JsonProperty(" personalData") PersonalData personalData,
                   @JsonProperty("workExperience") LocalDate workExperience) {
        this.id = id;
        this.personalData =personalData;
        this.workExperience = workExperience;
    }

//    public Doctor(DoctorId id, PersonalData personalData, LocalDate workExperience) {
//        this.id = id;
//        this.personalData =personalData;
//        this.workExperience = workExperience;
//    }
}
