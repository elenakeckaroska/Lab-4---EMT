package com.example.doctorpatient.doctor.domain.model;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class IsDoctorRelationId extends DomainObjectId {
    private IsDoctorRelationId() {
        super(IsDoctorRelationId.randomId(IsDoctorRelationId.class).getId());
    }

    public IsDoctorRelationId(String uuid) {
        super(uuid);
    }
}
