package com.example.doctorpatient.patient.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class PatientId extends DomainObjectId {
    private PatientId() {
        super(PatientId.randomId(PatientId.class).getId());
    }

    public PatientId(@NonNull String uuid) {
        super(uuid);
    }

    public static PatientId of(String uuid) {
        PatientId p = new PatientId(uuid);
        return p;
    }
}
