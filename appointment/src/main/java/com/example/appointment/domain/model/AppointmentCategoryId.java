package com.example.appointment.domain.model;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;


public class AppointmentCategoryId extends DomainObjectId {
    public AppointmentCategoryId(){
        super(AppointmentCategoryId.randomId(AppointmentCategoryId.class).getId());
    }

    public AppointmentCategoryId(@NonNull String uuid) {
        super(uuid);
    }
}
