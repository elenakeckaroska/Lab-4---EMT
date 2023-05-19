package com.example.appointment.domain.valueObjects;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObject;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class DoctorId extends DomainObjectId {
    public DoctorId() {
        super(DoctorId.randomId(DoctorId.class).getId());
    }

    public DoctorId(@NonNull String uuid) {
        super(uuid);
    }


}
