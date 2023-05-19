package com.example.doctorpatient.doctor.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;


public class DoctorId extends DomainObjectId {

    private DoctorId(){
        super(DoctorId.randomId(DoctorId.class).getId());
    }

    public DoctorId(@NonNull String uuid){
        super(uuid);
    }
    public static DoctorId of( String uuid) {
        DoctorId d = new DoctorId(uuid);
        return d;
    }

}
