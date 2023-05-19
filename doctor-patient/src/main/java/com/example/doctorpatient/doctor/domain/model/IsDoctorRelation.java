package com.example.doctorpatient.doctor.domain.model;

import mk.ukim.finki.emt.sharedkernel.events.appointments.PatientId;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;

import jakarta.persistence.*;

@Entity
@Table(name = "relations")
@Getter
public class IsDoctorRelation extends AbstractEntity<IsDoctorRelationId> {

    @AttributeOverrides({
            @AttributeOverride(name="id", column = @Column(name="patient_id"))
    })
    private PatientId patientId;
    private PersonalData personalData;


    public IsDoctorRelation(@NonNull PatientId patientId, @NonNull PersonalData data) {

        super(DomainObjectId.randomId(IsDoctorRelationId.class));
        this.patientId = patientId;

        this.personalData = data;
    }


    public IsDoctorRelation() {

    }

//    public IsDoctorRelation(PatientId id, PersonalData personalData) {
//        this.patientId = id;
//        this.personalData = personalData;
//    }
}
