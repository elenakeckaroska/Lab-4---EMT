package com.example.appointment.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class AppointmentId extends DomainObjectId {

    public AppointmentId(){
        super(AppointmentCategoryId.randomId(AppointmentCategoryId.class).getId());
    }

    public AppointmentId(@NonNull String uuid) {
        super(uuid);
    }
    public static AppointmentId of(String uuid) {
        AppointmentId p = new AppointmentId(uuid);
        return p;
    }
}
