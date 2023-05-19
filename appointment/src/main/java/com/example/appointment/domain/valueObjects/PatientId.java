package com.example.appointment.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

@Embeddable
public class PatientId extends DomainObjectId {
    public PatientId() {
        super(DoctorId.randomId(PatientId.class).getId());
    }

    public PatientId(@NonNull String uuid) {
        super(uuid);
    }

}
